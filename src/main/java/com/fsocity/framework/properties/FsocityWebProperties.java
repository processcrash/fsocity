package com.fsocity.framework.properties;

import com.fsocity.framework.security.properties.AdminWebSecurityProperties;
import com.fsocity.framework.security.properties.CorsProperties;
import com.fsocity.framework.security.properties.CsrfProperties;
import com.fsocity.framework.security.properties.WebSecurityProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zail
 * @date 2022/1/30
 */
@Data
@Component
@ConfigurationProperties(prefix = "fsocity.web")
public class FsocityWebProperties {
    
    /* 后台管理安全配置 */
    private AdminWebSecurityProperties admin = new AdminWebSecurityProperties();
    
    /* 安全配置 */
    private Map<String, WebSecurityProperties> security = new HashMap<>();
    // CSRF配置
    private CsrfProperties csrf = new CsrfProperties();
    // CORS配置
    private CorsProperties cors = new CorsProperties();
    
    
    
}
