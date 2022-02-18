package com.fsocity.framework.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fsocity.framework.security.properties.WebSecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zail
 * @since 2018-10-11
 */
@Component
@Slf4j
public class WebAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private WebSecurityProperties webSecurityProperties;
    
    private final RequestCache requestCache = new HttpSessionRequestCache();
    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        
        log.info("登录成功!");
        
        // 如果是 application/json 请求, 返回 json 数据
        String accept = request.getHeader("Accept");
        if (accept.contains(MediaType.APPLICATION_JSON_VALUE)) {
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write(objectMapper.writeValueAsString(authentication));
            return;
        }
        
        // 跳转
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        String targetUrl;
        if (savedRequest != null) {
            targetUrl = savedRequest.getRedirectUrl();
        }
        else {
            targetUrl = webSecurityProperties.getAdmin().getLoginSuccessUrl();
        }
        
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
}
