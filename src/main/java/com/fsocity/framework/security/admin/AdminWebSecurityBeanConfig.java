package com.fsocity.framework.security.admin;

import com.fsocity.framework.security.rememberme.MyJdbcTokenRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    
    @Bean
    public PersistentTokenRepository adminPersistentTokenRepository() {
        MyJdbcTokenRepositoryImpl persistentTokenRepository = new MyJdbcTokenRepositoryImpl();
        persistentTokenRepository.setDataSource(dataSource); // 设置数据源
        persistentTokenRepository.setTablePrefix("sys_"); // 设置表前缀
        persistentTokenRepository.setCreateTableOnStartup(false);
        return persistentTokenRepository;
    }
}
