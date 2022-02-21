package com.fsocity.framework.security.config;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zail
 * @date 2022/2/21
 */
class WebSecurityBeanConfigTest {
    
    @Test
    public void passwordEncoder() {
        PasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String a = bcrypt.encode("123456");
        System.out.println(a);
    }

}