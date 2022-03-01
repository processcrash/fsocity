package com.fsocity.modules.admin.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import com.fsocity.modules.admin.service.AdminJobLogService;
import io.swagger.annotations.ApiOperation;
import com.fsocity.modules.admin.entity.AdminJobLog;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.fsocity.framework.web.JsonResult;
import com.fsocity.framework.web.FieldErrorInfo;
import com.fsocity.framework.web.ResponseStatusEnum;
import com.fsocity.framework.util.ValidationUtils;

import java.util.List;

/**
 * <p>
 * 定时任务调度日志表 前端控制器
 * </p>
 *
 * @author Zail
 * @since 2022-03-02
 */
@RestController
@RequestMapping("/admin/api/adminJobLog")
public class AdminJobLogController {

    @Autowired
    private AdminJobLogService adminJobLogService;

    @ApiOperation("列表")
    @GetMapping({"", "/list"})
    public JsonResult list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                           AdminJobLog form) {
        Page<AdminJobLog> list = adminJobLogService.findAll(form, pageNum, pageSize);
        return JsonResult.ok(list);
    }

    @ApiOperation("详情")
    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable Integer id) {
        AdminJobLog adminJobLog = adminJobLogService.getById(id);
        return JsonResult.ok(adminJobLog);
    }

    @ApiOperation("保存")
    @PostMapping({"", "/save"})
    public JsonResult save(@RequestBody @Validated AdminJobLog adminJobLog,
                           BindingResult bindingResult) {
        List<FieldErrorInfo> errors = ValidationUtils.getErrors(bindingResult);
        if (CollectionUtils.isNotEmpty(errors)) {
            String errorMsg = "字段：" + errors.get(0).getName() + "；错误信息:" + errors.get(0).getErrorMessage();
            return JsonResult.err(ResponseStatusEnum.VALIDATE_FAILED.getCode(), errorMsg);
        }
        boolean flag = adminJobLogService.save(adminJobLog);
        return JsonResult.ok(flag);
    }

    @ApiOperation("删除")
    @DeleteMapping("/{id}")
    public JsonResult delete(@PathVariable Integer id) {
        boolean flag = adminJobLogService.deleteById(id);
        return JsonResult.ok(flag);
    }

}

