package com.fsocity.framework.security.filter;

import com.fsocity.framework.exception.WebException;
import com.fsocity.framework.security.validation.DefaultValidationCode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author zail
 * @date 2022/2/21
 */
public class ValidationCodeFilter extends OncePerRequestFilter {
    
    // 请求方法
    private final String httpMethod;
    // 处理登录的链接
    private final String loginProcessingUrl;
    // 验证码保存到 session 中的名称
    private final String sessionKey;
    // 登录失败处理器
    private final AuthenticationFailureHandler authenticationFailureHandler;
    
    public ValidationCodeFilter(String httpMethod, String loginProcessingUrl, String sessionKey, AuthenticationFailureHandler authenticationFailureHandler) {
        this.httpMethod = httpMethod;
        this.loginProcessingUrl = loginProcessingUrl;
        this.sessionKey = sessionKey;
        this.authenticationFailureHandler = authenticationFailureHandler;
    }
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // post 的登录请求
        if (loginProcessingUrl.equals(request.getRequestURI())
                && httpMethod.equalsIgnoreCase(request.getMethod())) {
            
            // 校验 validationCode
            try {
                validate(new ServletWebRequest(request, response));
            }
            catch (WebException e) {
                AuthenticationException ex = new InsufficientAuthenticationException(e.getMessage());
                // 直接调用失败处理器处理
                authenticationFailureHandler.onAuthenticationFailure(request, response, ex);
                return;
            }
            
            filterChain.doFilter(request, response);
        }
        else {
            filterChain.doFilter(request, response);
        }
    }
    
    /**
     * 校验验证码
     */
    private void validate(ServletWebRequest servletWebRequest) throws WebException {
        HttpSession session = servletWebRequest.getRequest().getSession();
        DefaultValidationCode validationCode =
                (DefaultValidationCode) session.getAttribute(sessionKey);
        
        String formValidationCode = servletWebRequest.getParameter("validationCode");
        
        if (StringUtils.isBlank(formValidationCode)) {
            throw new WebException("验证码不能为空!");
        }
        if (validationCode == null) {
            throw new WebException("验证码不存在!");
        }
        if (!validationCode.isNonExpired()) {
            servletWebRequest.getRequest().getSession().removeAttribute(sessionKey);
            throw new WebException("验证码已过期!");
        }
        if (!formValidationCode.toUpperCase().equals(validationCode.getCode().toUpperCase())) {
            throw new WebException("验证码错误!");
        }
        
        // 最后删除验证码
        servletWebRequest.getRequest().getSession().removeAttribute(sessionKey);
    }
}
