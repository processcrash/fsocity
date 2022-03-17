package com.fsocity.framework.security.admin;

import com.fsocity.framework.redis.RedisService;
import com.fsocity.framework.security.properties.WebSecurityProperties;
import com.fsocity.framework.security.jwt.JwtTokenUtils;
import com.fsocity.framework.security.validation.DefaultValidationCode;
import com.fsocity.framework.security.validation.ImageValidationCode;
import com.fsocity.framework.security.validation.ImageValidationCodeGenerator;
import com.fsocity.framework.security.validation.ValidationCode;
import com.fsocity.framework.web.JsonResult;
import com.fsocity.framework.web.ResponseStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zail
 * @date 2022/2/18
 */
@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminSecurityController {
    
    private final RequestCache requestCache = new HttpSessionRequestCache();
    // 验证码保存到 session 中的名称
    public static final String VALIDATION_CODE_SESSION_KEY = "__VALIDATION_CODE_SESSION_KEY";
    
    @Autowired
    private ImageValidationCodeGenerator imageValidationCodeGenerator;
    @Autowired
    private WebSecurityProperties webSecurityProperties;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtils jwtTokenUtils;
    @Autowired
    private RedisService redisService;
    
    @GetMapping("/login")
    public String login() {
        return "thymeleaf/admin/login";
    }
    
    @PostMapping("/api/login")
    @ResponseBody
    public JsonResult apiLogin(@RequestBody @Validated AdminLoginForm form,
                               BindingResult bindingResult) {
        UserDetails userDetails = null;
        try {
            userDetails = userDetailsService.loadUserByUsername(form.getUsername());
        }
        catch (UsernameNotFoundException e) {
            // e.printStackTrace();
            return JsonResult.err(1, e.getMessage());
        }
        
        boolean match = passwordEncoder.matches(form.getPassword(), userDetails.getPassword());
        if (!match) {
            return JsonResult.err(1, "密码错误！");
        }
        String token = jwtTokenUtils.generateToken(userDetails);
        redisService.set("admin:jwttoken:" + userDetails.getUsername(), token, webSecurityProperties.getAdmin().getRememberMeSeconds());
        
        AdminLoginResult result = new AdminLoginResult();
        result.setUsername(userDetails.getUsername());
        result.setJwtToken(token);
        // 保存到redis里
        return JsonResult.ok(result);
    }
    
    /**
     * 当需要身份认证时跳转到这里处理
     */
    @GetMapping(value = "/authenticationRequire", produces = MediaType.TEXT_HTML_VALUE)
    public String requireAuthenticationHtml(HttpServletRequest request,
                                            HttpServletResponse response) {
        
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            log.info("需要登录引发的跳转 url = {}", targetUrl);
        }
        
        return "redirect:" + webSecurityProperties.getAdmin().getLoginPage();
    }
    
    @GetMapping(value = "/authenticationRequire")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public JsonResult requireAuthentication(HttpServletRequest request,
                                            HttpServletResponse response) {
        
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            log.info("需要登录引发的跳转 url = {}", targetUrl);
        }
        
        return JsonResult.err(ResponseStatusEnum.UNAUTHORIZED);
    }
    
    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "thymeleaf/admin/accessDenied";
    }
    
    @GetMapping({"", "/index"})
    public String index() {
        return "thymeleaf/admin/index";
    }
    
    /**
     * 图形验证码
     */
    @GetMapping("/validationCode/image")
    public void imageCode(HttpServletRequest request,
                          HttpServletResponse response) throws IOException {
        // 创建验证码
        ImageValidationCode imageValidationCode = imageValidationCodeGenerator.generate();
        
        // 保存到 session 中
        ValidationCode validationCode = new DefaultValidationCode(imageValidationCode.getCode(), imageValidationCode.getExpireTime());
        request.getSession().setAttribute(VALIDATION_CODE_SESSION_KEY, validationCode);
        
        // 写到响应中
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        ImageIO.write(imageValidationCode.getImage(), "png", response.getOutputStream());
    }
}
