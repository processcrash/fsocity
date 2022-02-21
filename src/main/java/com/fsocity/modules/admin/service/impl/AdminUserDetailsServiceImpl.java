package com.fsocity.modules.admin.service.impl;

import com.fsocity.framework.security.admin.AdminUserDetails;
import com.fsocity.framework.web.enums.DeleteStatusEnum;
import com.fsocity.modules.admin.entity.AdminUser;
import com.fsocity.modules.admin.service.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zail
 * @date 2022/2/21
 */
@Service
@Slf4j
public class AdminUserDetailsServiceImpl implements UserDetailsService {
    
    @Autowired
    private AdminUserService adminUserService;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminUser adminUser = adminUserService.getByUsername(username);
        if (adminUser == null) {
            throw new UsernameNotFoundException("用户不存在!");
        }
        if (adminUser.getStatus().equals(DeleteStatusEnum.DELETED.getCode())) {
            throw new UsernameNotFoundException("用户已删除!");
        }
        // 用户权限
        List<GrantedAuthority> authorities = new LinkedList<>();
        
        return new AdminUserDetails(
                adminUser.getId(),
                adminUser.getRealname(),
                adminUser.getUsername(),
                adminUser.getPassword(),
                authorities);
    }
}
