package com.fsocity.framework.security.config;

import com.fsocity.framework.security.authentication.JwtAuthenticationTokenFilter;
import com.fsocity.framework.security.properties.WebSecurityProperties;
import com.fsocity.framework.security.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zail
 * @date 2022/1/24
 */
@Configuration
public class WebSecurityBeanConfig {
    
    @Autowired
    private WebSecurityProperties webSecurityProperties;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private DataSource dataSource;
    
    /**
     * 密码加密工具
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        String id = "BCrypt"; // 默认使用什么方式加密
        PasswordEncoder bcrypt = new BCryptPasswordEncoder();
        
        Map<String, PasswordEncoder> idToPasswordEncoder = new HashMap<>();
        idToPasswordEncoder.put("BCrypt", bcrypt);
        
        return new DelegatingPasswordEncoder(id, idToPasswordEncoder);
    }
    
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl r = new JdbcTokenRepositoryImpl();
        r.setDataSource(dataSource);
        return r;
    }
    
    @Bean
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil(webSecurityProperties.getJwt());
    }
    
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter(
                webSecurityProperties.getJwt(),
                jwtTokenUtil(),
                userDetailsService);
    }
    
}
