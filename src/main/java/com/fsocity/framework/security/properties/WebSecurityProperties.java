package com.fsocity.framework.security.properties;

import com.fsocity.framework.security.admin.AdminWebSecurityProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author zail
 * @date 2022/1/24
 */
@Data
@ConfigurationProperties(prefix = "fsocity.security")
@Component
public class WebSecurityProperties {
    
    // Admin 安全配置
    private AdminWebSecurityProperties admin = new AdminWebSecurityProperties();
    
    // CSRF配置
    private CsrfProperties csrf = new CsrfProperties();
    
    // CORS配置
    private CorsProperties cors = new CorsProperties();
    
}
