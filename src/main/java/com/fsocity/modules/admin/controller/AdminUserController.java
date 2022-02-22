package com.fsocity.modules.admin.controller;


import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.framework.util.ValidationUtils;
import com.fsocity.framework.web.FieldErrorInfo;
import com.fsocity.framework.web.JsonResult;
import com.fsocity.framework.web.ResponseStatusEnum;
import com.fsocity.modules.admin.entity.AdminUser;
import com.fsocity.modules.admin.service.AdminUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author Zail
 * @since 2022-02-22
 */
@RestController
@RequestMapping("/admin/api/adminUser")
public class AdminUserController {
    
    @Autowired
    private AdminUserService adminUserService;
    
    @ApiOperation("列表")
    @GetMapping("/list")
    public JsonResult list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                           AdminUser form) {
        
        Page<AdminUser> list = adminUserService.findAll(form, pageNum, pageSize);
        return JsonResult.ok(list);
    }
    
    @ApiOperation("详情")
    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable Integer id) {
        AdminUser adminUser = adminUserService.getById(id);
        return JsonResult.ok(adminUser);
    }
    
    @ApiOperation("保存")
    @PostMapping("/save")
    public JsonResult save(@RequestBody @Validated AdminUser adminUser,
                           BindingResult bindingResult) {
        List<FieldErrorInfo> errors = ValidationUtils.getErrors(bindingResult);
        if (CollectionUtils.isNotEmpty(errors)) {
            String errorMsg = "字段：" + errors.get(0).getName() + "；错误信息:" + errors.get(0).getErrorMessage();
            return JsonResult.err(ResponseStatusEnum.VALIDATE_FAILED.getCode(), errorMsg);
        }
        boolean flag = adminUserService.save(adminUser);
        return JsonResult.ok(flag);
    }
    
    @ApiOperation("删除")
    @PostMapping("/delete/{id}")
    public JsonResult delete(@PathVariable Integer id) {
        boolean flag = adminUserService.deleteById(id);
        return JsonResult.ok(flag);
    }
    
}

