package com.fsocity.framework.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author zail
 * @date 2022/1/24
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.fsocity.modules.*.mapper"})
public class MyBatisConfiguration {
    
}
