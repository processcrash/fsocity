package com.fsocity;

import com.fsocity.modules.system.entity.SysConfig;
import com.fsocity.modules.system.service.SysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zail
 * @date 2022/1/30
 */
@Controller
public class IndexController {
    
    @Autowired
    private SysConfigService sysConfigService;
    
    /**
     * 首页
     */
    @GetMapping("/")
    public String index() {
        SysConfig sysConfig = sysConfigService.getById(1);
        System.out.println(sysConfig);
        return "thymeleaf/www/index";
    }
    
}
