package com.fsocity.modules.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zail
 * @date 2022/1/30
 */
@Controller
public class WWWIndexController {
    
    /**
     * 首页
     */
    @GetMapping
    public String index() {
        return "thymeleaf/www/index";
    }
    
}
