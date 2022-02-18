package com.fsocity.framework.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zail
 * @date 2022/2/18
 */
@Controller
@RequestMapping("/admin")
public class AdminSecurityController {
    
    @GetMapping("/login")
    public String login() {
        return "thymeleaf/admin/login";
    }
    
    @GetMapping("/authenticationRequire")
    public String authenticationRequire() {
        return "thymeleaf/admin/authenticationRequire";
    }
    
    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "thymeleaf/admin/accessDenied";
    }
    
    @GetMapping("/index")
    public String index() {
        return "thymeleaf/admin/index";
    }
}
