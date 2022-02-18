package com.fsocity.framework.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fsocity.framework.exception.WebException;
import com.fsocity.framework.security.properties.WebSecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author zail
 * @since 2018-10-11
 */
@Component
@Slf4j
public class WebAuthenticationFailureHandler implements AuthenticationFailureHandler {
    
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private WebSecurityProperties webSecurityProperties;
    
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    
    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception) throws IOException, ServletException {
        
        log.error("登录失败! exception = {}", exception.toString());
        
        // 如果是 application/json 请求, 返回 json 数据
        String accept = request.getHeader("Accept");
        if (accept.contains(MediaType.APPLICATION_JSON_VALUE)) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write(objectMapper.writeValueAsString(exception));
            return;
        }
        
        // 跳转到登录页面重新登录
        saveException(request, exception);
        redirectStrategy.sendRedirect(request, response, webSecurityProperties.getAdmin().getLoginPage());
    }
    
    /**
     * 保存错误信息
     */
    private void saveException(HttpServletRequest request, AuthenticationException exception) {
        HttpSession session = request.getSession();
        if (session != null) {
            if (exception instanceof BadCredentialsException) {
                request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, new WebException("账号或密码错误！"));
            }
            else {
                request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION, exception);
            }
        }
    }
}
