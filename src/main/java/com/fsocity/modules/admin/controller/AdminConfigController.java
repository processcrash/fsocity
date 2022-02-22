package com.fsocity.modules.admin.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import com.fsocity.modules.admin.service.AdminConfigService;
import io.swagger.annotations.ApiOperation;
import com.fsocity.modules.admin.entity.AdminConfig;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.fsocity.framework.web.JsonResult;
import com.fsocity.framework.web.FieldErrorInfo;
import com.fsocity.framework.web.ResponseStatusEnum;
import com.fsocity.framework.util.ValidationUtils;

import java.util.List;

/**
 * <p>
 * 参数配置表 前端控制器
 * </p>
 *
 * @author Zail
 * @since 2022-02-22
 */
@RestController
@RequestMapping("/admin/api/adminConfig")
public class AdminConfigController {

@Autowired
private AdminConfigService adminConfigService;

    @ApiOperation("列表")
    @GetMapping("/list")
    public JsonResult list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                           AdminConfig form) {
        Page<AdminConfig> list = adminConfigService.findAll(form, pageNum, pageSize);
        return JsonResult.ok(list);
    }

    @ApiOperation("详情")
    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable Integer id) {
        AdminConfig adminConfig = adminConfigService.getById(id);
        return JsonResult.ok(adminConfig);
    }

    @ApiOperation("保存")
    @PostMapping("/save")
    public JsonResult save(@RequestBody @Validated AdminConfig adminConfig,
                           BindingResult bindingResult) {
        List<FieldErrorInfo> errors = ValidationUtils.getErrors(bindingResult);
        if (CollectionUtils.isNotEmpty(errors)) {
            String errorMsg = "字段：" + errors.get(0).getName() + "；错误信息:" + errors.get(0).getErrorMessage();
            return JsonResult.err(ResponseStatusEnum.VALIDATE_FAILED.getCode(), errorMsg);
        }
        boolean flag = adminConfigService.save(adminConfig);
        return JsonResult.ok(flag);
    }

    @ApiOperation("删除")
    @PostMapping("/delete/{id}")
    public JsonResult delete(@PathVariable Integer id) {
        boolean flag = adminConfigService.deleteById(id);
        return JsonResult.ok(flag);
    }

}

