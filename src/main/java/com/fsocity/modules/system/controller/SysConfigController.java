package com.fsocity.modules.system.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.fsocity.modules.system.service.SysConfigService;
import io.swagger.annotations.ApiOperation;
import com.fsocity.modules.system.entity.SysConfig;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.framework.web.JsonResult;
import org.springframework.validation.BindingResult;

/**
 * system前端控制器
 *
 * @author Zail
 * @since 2022-01-30
 */
@RestController
@RequestMapping("/admin/api/system/sysConfig")
public class SysConfigController {
    
    @Autowired
    private SysConfigService sysConfigService;

    @ApiOperation("列表")
    @GetMapping("/list")
    public JsonResult list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<SysConfig> list = sysConfigService.findAll(pageSize, pageNum);
        return JsonResult.ok(list);
    }

    @ApiOperation("详情")
    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable Integer id) {
        SysConfig sysConfig = sysConfigService.getById(id);
        return JsonResult.ok(sysConfig);
    }

    @ApiOperation("修改")
    @PostMapping("/edit")
    public JsonResult edit(@RequestBody @Validated SysConfig sysConfig,
                           BindingResult bindingResult) {
        // todo
        return JsonResult.ok();
    }

    @ApiOperation("新增")
    @PostMapping("/save")
    public JsonResult save(@RequestBody @Validated SysConfig sysConfig,
                           BindingResult bindingResult) {
        // todo
        return JsonResult.ok();
    }

    @ApiOperation("删除")
    @PostMapping("/delete/{id}")
    public JsonResult delete(@PathVariable Integer id) {
        SysConfig sysConfig = sysConfigService.deleteById(id);
        return JsonResult.ok();
    }
}

