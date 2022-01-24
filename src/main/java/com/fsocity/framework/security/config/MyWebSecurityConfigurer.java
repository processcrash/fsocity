package com.fsocity.framework.security.config;

import com.fsocity.framework.security.authentication.JwtAuthenticationTokenFilter;
import com.fsocity.framework.security.authentication.WebAccessDeniedHandler;
import com.fsocity.framework.security.authentication.WebAuthenticationFailureHandler;
import com.fsocity.framework.security.authentication.WebAuthenticationSuccessHandler;
import com.fsocity.framework.security.properties.WebSecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


/**
 * 对SpringSecurity的配置的扩展，支持自定义白名单资源路径和查询用户逻辑
 * Created by macro on 2019/11/5.
 */
@Configuration
public class MyWebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private WebSecurityProperties webSecurityProperties;
    @Autowired
    private WebAuthenticationSuccessHandler webAuthenticationSuccessHandler;
    @Autowired
    private WebAuthenticationFailureHandler webAuthenticationFailureHandler;
    @Autowired
    private WebAccessDeniedHandler webAccessDeniedHandler;
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    @Autowired
    private PersistentTokenRepository persistentTokenRepository;
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    
        http
                // JWT 认证过滤器
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                // 增加验证码验证过滤器
                // .addFilterBefore(validationCodeFilter, UsernamePasswordAuthenticationFilter.class)
            
                // 配置表单登录
                .formLogin()
                .loginPage(webSecurityProperties.getRequireAuthenticationUrl()) // 处理登录页面
                .loginProcessingUrl(webSecurityProperties.getLoginProcessingUrl()) // 处理登录的 url
            
                .successHandler(webAuthenticationSuccessHandler) // 配置登录成功处理器
                .failureHandler(webAuthenticationFailureHandler) // 配置登录失败处理器
                .and()
            
                // 配置退出登录
                .logout()
                .logoutUrl(webSecurityProperties.getLogoutUrl())
                .and()
            
                // 配置 记住我
                .rememberMe()
                .rememberMeParameter(webSecurityProperties.getRememberMeName())
                .tokenRepository(persistentTokenRepository)
                .tokenValiditySeconds(webSecurityProperties.getRememberMeSeconds())
                .userDetailsService(userDetailsService)
                .and()
            
                // 身份请求认证
                .authorizeRequests()
            
                // 配置不需要身份认证的链接
                .antMatchers(webSecurityProperties.getUnauthenticatedUrls())
                .permitAll()
            
                // 配置需要身份认证的链接
                .antMatchers(webSecurityProperties.getAuthenticatedUrls())
                .authenticated()
                .and()
                
                // 配置头
                .headers()
                .frameOptions()
                .disable()
            
                .and()
                .exceptionHandling() // 异常处理
                .accessDeniedHandler(webAccessDeniedHandler) // 配置访问拒绝处理器
                .accessDeniedPage(webSecurityProperties.getAccessDeniedUrl());
        
        if (!webSecurityProperties.getCsrf().getEnable()) {
            http
                    .csrf()
                    .disable(); // 关闭csrf
        }
        if (!webSecurityProperties.getCors().getEnable()) {
            http
                    .cors()
                    .disable(); // 关闭cors
        }
        
    }
    
}
