package com.fsocity.framework.security.admin;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author zail
 * @date 2022/2/22
 */
@Data
public class AdminLoginForm {
    
    @NotNull
    private String username;
    
    @NotNull
    private String password;
    
    private Boolean rememberMe;
    
}
