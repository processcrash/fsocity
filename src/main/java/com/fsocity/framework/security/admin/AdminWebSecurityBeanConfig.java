package com.fsocity.framework.security.admin;

import com.fsocity.framework.security.filter.ValidationCodeFilter;
import com.fsocity.framework.security.properties.WebSecurityProperties;
import com.fsocity.framework.security.rememberme.MyJdbcTokenRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import javax.sql.DataSource;

/**
 * @author zail
 * @date 2022/2/21
 */
@Configuration
public class AdminWebSecurityBeanConfig {
    
    @Autowired
    private DataSource dataSource;
    @Autowired
    private WebSecurityProperties webSecurityProperties;
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
    
    @Bean
    public PersistentTokenRepository adminPersistentTokenRepository() {
        MyJdbcTokenRepositoryImpl persistentTokenRepository = new MyJdbcTokenRepositoryImpl();
        persistentTokenRepository.setDataSource(dataSource); // 设置数据源
        persistentTokenRepository.setTablePrefix("tb_admin_"); // 设置表前缀
        persistentTokenRepository.setCreateTableOnStartup(false);
        return persistentTokenRepository;
    }
    
    @Bean
    public ValidationCodeFilter adminValidationCodeFilter() {
        return new ValidationCodeFilter(
                "POST",
                webSecurityProperties.getAdmin().getLoginProcessingUrl(),
                AdminSecurityController.VALIDATION_CODE_SESSION_KEY,
                authenticationFailureHandler
        );
    }
}
