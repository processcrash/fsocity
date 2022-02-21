package com.fsocity.framework.security.admin;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @author zail
 * @date 2022/2/21
 */
public class AdminUserDetails extends User {
    
    // user id
    private final Integer userId;
    
    private final String realname;
    
    public AdminUserDetails(Integer userId,
                            String realname,
                            String username,
                            String password,
                            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.userId = userId;
        this.realname = realname;
    }
    
    public AdminUserDetails(Integer userId,
                            String realname,
                            String username,
                            String password,
                            boolean enabled,
                            boolean accountNonExpired,
                            boolean credentialsNonExpired,
                            boolean accountNonLocked,
                            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userId = userId;
        this.realname = realname;
    }
    
    public Integer getUserId() {
        return userId;
    }
    
    public String getRealname() {
        return realname;
    }
}
