package com.fsocity.modules.system.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.fsocity.modules.system.service.SysRoleDepartmentService;
import io.swagger.annotations.ApiOperation;
import com.fsocity.modules.system.entity.SysRoleDepartment;
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
@RequestMapping("/admin/api/system/sysRoleDepartment")
public class SysRoleDepartmentController {
    
    @Autowired
    private SysRoleDepartmentService sysRoleDepartmentService;

    @ApiOperation("列表")
    @GetMapping("/list")
    public JsonResult list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                           @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<SysRoleDepartment> list = sysRoleDepartmentService.findAll(pageSize, pageNum);
        return JsonResult.ok(list);
    }

    @ApiOperation("详情")
    @GetMapping("/{id}")
    public JsonResult detail(@PathVariable Integer id) {
        SysRoleDepartment sysRoleDepartment = sysRoleDepartmentService.getById(id);
        return JsonResult.ok(sysRoleDepartment);
    }

    @ApiOperation("修改")
    @PostMapping("/edit")
    public JsonResult edit(@RequestBody @Validated SysRoleDepartment sysRoleDepartment,
                           BindingResult bindingResult) {
        // todo
        return JsonResult.ok();
    }

    @ApiOperation("新增")
    @PostMapping("/save")
    public JsonResult save(@RequestBody @Validated SysRoleDepartment sysRoleDepartment,
                           BindingResult bindingResult) {
        // todo
        return JsonResult.ok();
    }

    @ApiOperation("删除")
    @PostMapping("/delete/{id}")
    public JsonResult delete(@PathVariable Integer id) {
        SysRoleDepartment sysRoleDepartment = sysRoleDepartmentService.deleteById(id);
        return JsonResult.ok();
    }
}

