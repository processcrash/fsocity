package com.fsocity.framework.security.properties;

import lombok.Data;

/**
 * @author zail
 * @date 2022/2/5
 */
@Data
public class AdminWebSecurityProperties {
    
    // 是否开启
    private boolean enable = true;
    
    // 需要身份认证的匹配链接
    private String[] authenticatedUrls = {"/admin", "/admin/**"};
    
    // 不需要身份认证的匹配链接
    private String[] unauthenticatedUrls = {};
    
    // 提示需要登录页面
    private String requireAuthenticationUrl = "/admin/authentication/require";
    
    // 登录页面
    private String loginPage = "/admin/login";
    
    // 处理登录的链接
    private String loginProcessingUrl = "/admin/login";
    
    // 退出登录 url
    private String logoutUrl = "/admin/logout";
    
    // 登录成功跳转的 url
    private String loginSuccessUrl = "/admin/index";
    
    // 访问拒绝页面
    private String accessDeniedUrl = "/admin/access/denied";
    
    // 验证码配置
    private ValidationCodeProperties validationCode = new ValidationCodeProperties();
    
    // 记住我
    private String rememberMeName = "rememberMe";
    
    // 记住我时间配置(单位秒)
    private Integer rememberMeSeconds = 3600 * 2;
    
    // jwt 配置
    private JWTProperties jwt = new JWTProperties();
    
}
