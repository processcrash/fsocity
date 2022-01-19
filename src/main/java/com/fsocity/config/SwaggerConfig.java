package com.fsocity.config;

import com.fsocity.common.config.BaseSwaggerConfig;
import com.fsocity.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger API文档相关配置
 * Created by macro on 2018/4/26.
 */
@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.fsocity.modules")
                .title("Fsocity 脚手架")
                .description("接口文档")
                .contactName("Zail")
                .version("1.0.0")
                .enableSecurity(true)
                .build();
    }
}
