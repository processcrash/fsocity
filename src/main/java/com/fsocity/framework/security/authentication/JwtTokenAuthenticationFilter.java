package com.fsocity.framework.security.authentication;

import com.fsocity.framework.security.properties.JWTProperties;
import com.fsocity.framework.security.jwt.JwtTokenUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT登录授权过滤器
 * Created by macro on 2018/4/26.
 */
public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(JwtTokenAuthenticationFilter.class);
    
    private final AntPathMatcher antPathMatcher = new AntPathMatcher();
    
    // 需要身份认证的匹配链接
    private final String[] authenticatedUrls;
    
    // 不需要身份认证的匹配链接
    private final String[] unauthenticatedUrls;
    
    // jwt 配置
    private final JWTProperties jwtProperties;
    
    // jwt工具
    private final JwtTokenUtils jwtTokenUtils;
    
    private final UserDetailsService userDetailsService;
    
    // 登录失败处理器
    private final AuthenticationFailureHandler authenticationFailureHandler;
    
    public JwtTokenAuthenticationFilter(String[] authenticatedUrls, String[] unauthenticatedUrls, JWTProperties jwtProperties, JwtTokenUtils jwtTokenUtils, UserDetailsService userDetailsService, AuthenticationFailureHandler authenticationFailureHandler) {
        this.authenticatedUrls = authenticatedUrls;
        this.unauthenticatedUrls = unauthenticatedUrls;
        this.jwtProperties = jwtProperties;
        this.jwtTokenUtils = jwtTokenUtils;
        this.userDetailsService = userDetailsService;
        this.authenticationFailureHandler = authenticationFailureHandler;
    }
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        boolean matched = match(request.getRequestURI());
        if (matched) {
            // 获取header的值
            String authHeader = request.getHeader(jwtProperties.getHttpHeaderName());
            if (authHeader != null && authHeader.startsWith(jwtProperties.getTokenHead())) {
                // The part after "Bearer "
                String authToken = authHeader.substring(jwtProperties.getTokenHead().length());
                String username = jwtTokenUtils.getUserNameFromToken(authToken);
                LOGGER.info("checking username:{}", username);
                if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    UserDetails userDetails = null;
                    try {
                        userDetails = userDetailsService.loadUserByUsername(username);
                    }
                    catch (UsernameNotFoundException e) {
                        // e.printStackTrace();
                        // 快速结束
                        authenticationFailureHandler.onAuthenticationFailure(request, response, e);
                        return;
                    }
                    if (userDetails != null && jwtTokenUtils.validateToken(authToken, userDetails)) {
                        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                        LOGGER.info("authenticated user:{}", username);
                        // 设置好认证，以后的filter可以直接过
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                    }
                }
            }
        }
        chain.doFilter(request, response);
    }
    
    private boolean match(String uri) {
        // 不验证的链接
        for (String unauthenticatedUrl : unauthenticatedUrls) {
            boolean match = antPathMatcher.match(unauthenticatedUrl, uri);
            if (match) {
                return false;
            }
        }
        // 需要验证的链接
        for (String authenticatedUrl : authenticatedUrls) {
            boolean match = antPathMatcher.match(authenticatedUrl, uri);
            if (match) {
                return true;
            }
        }
        return false;
    }
    
}
