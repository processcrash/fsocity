package com.fsocity.framework.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
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
