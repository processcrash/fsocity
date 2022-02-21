package com.fsocity.framework.security.config;

import com.fsocity.framework.security.authentication.JwtAuthenticationTokenFilter;
import com.fsocity.framework.security.properties.WebSecurityProperties;
import com.fsocity.framework.security.util.JwtTokenUtil;
import com.fsocity.framework.security.validation.ImageValidationCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    public JwtTokenUtil jwtTokenUtil() {
        return new JwtTokenUtil(webSecurityProperties.getAdmin().getJwt());
    }
    
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter() {
        return new JwtAuthenticationTokenFilter(
                webSecurityProperties.getAdmin().getJwt(),
                jwtTokenUtil(),
                userDetailsService);
    }
    
    /**
     * 图形验证码生成器
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(name = "imageValidationCodeGenerator")
    public ImageValidationCodeGenerator imageValidationCodeGenerator() {
        ImageValidationCodeGenerator generator = new ImageValidationCodeGenerator();
        generator.setWidth(webSecurityProperties.getAdmin().getValidationCode().getWidth());
        generator.setHeight(webSecurityProperties.getAdmin().getValidationCode().getHeight());
        generator.setFontSize(30);
        generator.setLines(5);
        generator.setLength(webSecurityProperties.getAdmin().getValidationCode().getLength());
        generator.setExpireIn(webSecurityProperties.getAdmin().getValidationCode().getExpireIn());
        return generator;
    }
    
}
