package com.fsocity.framework.security.admin;

import lombok.Data;

/**
 * @author zail
 * @date 2022/2/22
 */
@Data
public class AdminLoginResult {
    
    private String username;
    
    private String token;
}
