package com.fsocity.framework.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fsocity.framework.security.properties.WebSecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 系统访问拒绝处理器, 用于处理权限不足时拒绝访问的返回信息
 *
 * @author zail
 * @since 2019-04-03
 */
@Component
@Slf4j
public class WebAccessDeniedHandler implements AccessDeniedHandler {
    
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private WebSecurityProperties webSecurityProperties;
    
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        log.error("访问拒绝! exception = {}", accessDeniedException.toString());
        
        // 如果是 application/json 请求, 返回 json 数据
        String accept = request.getHeader("Accept");
        if (accept.contains(MediaType.APPLICATION_JSON_VALUE)) {
            response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write(objectMapper.writeValueAsString(accessDeniedException));
            
            return;
        }
        
        // 跳转到访问拒绝页面
        redirectStrategy.sendRedirect(request, response, webSecurityProperties.getAccessDeniedUrl());
    }
    
}
