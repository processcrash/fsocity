package com.fsocity.modules.admin.controller;

import com.fsocity.framework.web.JsonResult;
import com.fsocity.modules.admin.entity.AdminUser;
import com.fsocity.modules.admin.service.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminCurrentUserController {
    
    @Autowired
    private AdminUserService adminUserService;
    
    /**
     * 当前登录的用户
     * 使用 @AuthenticationPrincipal 注解, 让 spring 注入 UserDetails 对象,
     * 该对象为登录的用户信息
     */
    @GetMapping("/api/currentUser")
    @ResponseBody
    public JsonResult currentUser(@AuthenticationPrincipal UserDetails userDetails) {
        AdminUser user = adminUserService.getByUsername(userDetails.getUsername());
        // 设置一个固定头像
        user.setAvatar("https://avatars.githubusercontent.com/u/16249943?v=4");
        return JsonResult.success(user);
    }
}
