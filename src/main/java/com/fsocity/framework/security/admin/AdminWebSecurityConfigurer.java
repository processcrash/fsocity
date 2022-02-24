package com.fsocity.framework.security.admin;

import com.fsocity.framework.security.authentication.JwtTokenAuthenticationFilter;
import com.fsocity.framework.security.authentication.WebAccessDeniedHandler;
import com.fsocity.framework.security.authentication.WebAuthenticationFailureHandler;
import com.fsocity.framework.security.authentication.WebAuthenticationSuccessHandler;
import com.fsocity.framework.security.filter.ValidationCodeFilter;
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
public class AdminWebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private WebSecurityProperties webSecurityProperties;
    @Autowired
    private WebAuthenticationSuccessHandler webAuthenticationSuccessHandler;
    @Autowired
    private WebAuthenticationFailureHandler webAuthenticationFailureHandler;
    @Autowired
    private WebAccessDeniedHandler webAccessDeniedHandler;
    @Autowired
    private JwtTokenAuthenticationFilter adminJwtAuthenticationTokenFilter;
    @Autowired
    private PersistentTokenRepository adminPersistentTokenRepository;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private ValidationCodeFilter adminValidationCodeFilter;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if (!webSecurityProperties.getCsrf().isEnable()) {
            http.csrf().disable(); // 关闭csrf
        }
        if (!webSecurityProperties.getCors().isEnable()) {
            http.cors().disable(); // 关闭cors
        }
    
        // 如果不开启
        if (!webSecurityProperties.getAdmin().isEnable()) {
            http.httpBasic().disable().formLogin().disable();
            return;
        }
        
        // 是否开启JWT认证
        if (webSecurityProperties.getAdmin().getJwt().isEnable()) {
            http.addFilterBefore(adminJwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        }
        
        http
                // 增加验证码验证过滤器
                .addFilterBefore(adminValidationCodeFilter, UsernamePasswordAuthenticationFilter.class)
                
                // 配置表单登录
                .formLogin()
                .loginPage(webSecurityProperties.getAdmin().getRequireAuthenticationUrl()) // 处理登录页面
                .loginProcessingUrl(webSecurityProperties.getAdmin().getLoginProcessingUrl()) // 处理登录的 url
                .successHandler(webAuthenticationSuccessHandler) // 配置登录成功处理器
                .failureHandler(webAuthenticationFailureHandler) // 配置登录失败处理器
                .and()
        
                // session 配置
                .sessionManagement()
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false) // 当达到最大值时，是否保留已经登录的用户
                // .expiredSessionStrategy() // 当达到最大值时，旧用户被踢出后的操作
                .and()
                .and()
        
                // 配置退出登录
                .logout()
                .logoutUrl(webSecurityProperties.getAdmin().getLogoutUrl())
                .logoutSuccessUrl(webSecurityProperties.getAdmin().getLoginPage())
                .and()
                
                // 配置 记住我
                .rememberMe()
                .rememberMeParameter(webSecurityProperties.getAdmin().getRememberMeName())
                .tokenRepository(adminPersistentTokenRepository)
                .tokenValiditySeconds(webSecurityProperties.getAdmin().getRememberMeSeconds())
                .userDetailsService(userDetailsService)
                .and()
                
                // 身份请求认证
                .authorizeRequests()
                
                // 配置不需要身份认证的链接
                .antMatchers(webSecurityProperties.getAdmin().getUnauthenticatedUrls())
                .permitAll()
                
                // 配置需要身份认证的链接
                .antMatchers(webSecurityProperties.getAdmin().getAuthenticatedUrls())
                .authenticated()
                .and()
                
                // 配置头
                .headers()
                .frameOptions()
                .disable()
                
                .and()
                .exceptionHandling() // 异常处理
                .accessDeniedHandler(webAccessDeniedHandler) // 配置访问拒绝处理器
                .accessDeniedPage(webSecurityProperties.getAdmin().getAccessDeniedUrl());
        
    }
    
}
