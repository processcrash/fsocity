package com.fsocity.framework.security;

import com.fsocity.framework.security.properties.WebSecurityProperties;
import com.fsocity.framework.web.JsonResult;
import com.fsocity.framework.web.ResponseStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zail
 * @date 2022/2/18
 */
@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminSecurityController {
    
    private final RequestCache requestCache = new HttpSessionRequestCache();
    
    @Autowired
    private WebSecurityProperties webSecurityProperties;
    
    @GetMapping("/login")
    public String login() {
        return "thymeleaf/admin/login";
    }
    
    @GetMapping("/authenticationRequire")
    public String authenticationRequire() {
        return "thymeleaf/admin/authenticationRequire";
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
    
    @GetMapping(value = "/authentication/require")
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
    
    @GetMapping("/index")
    public String index() {
        return "thymeleaf/admin/index";
    }
    
    /**
     * 当前登录的用户
     * 使用 @AuthenticationPrincipal 注解, 让 spring 注入 UserDetails 对象,
     * 该对象为登录的用户信息
     */
    @GetMapping("/currentUser")
    @ResponseBody
    public JsonResult getCurrentUser(@AuthenticationPrincipal UserDetails userDetails) {
        return JsonResult.success(userDetails);
    }
}
