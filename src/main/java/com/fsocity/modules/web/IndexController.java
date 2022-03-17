package com.fsocity.modules.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zail
 * @date 2022/1/30
 */
@Controller
public class IndexController {
    
    /**
     * 首页
     */
    @GetMapping({"", "/index"})
    public String index() {
        return "thymeleaf/index";
    }
    
}
