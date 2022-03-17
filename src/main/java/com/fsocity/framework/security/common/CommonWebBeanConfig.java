package com.fsocity.framework.security.common;

import com.fsocity.framework.web.filter.PrintRequestPathFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.Filter;

@Configuration
public class CommonWebBeanConfig {
    
    /**
     * 注册一个过滤器 bean 用于打印访问的链接和访问耗时。
     */
    @Bean
    public FilterRegistrationBean<GenericFilterBean> printRequestPathFilter() {
        FilterRegistrationBean<GenericFilterBean> registration = new FilterRegistrationBean<>();
        registration.setFilter(new PrintRequestPathFilter());
        registration.addUrlPatterns("/*");
        registration.setName("printRequestPathFilter");
        registration.setOrder(1);
        return registration;
    }
}
