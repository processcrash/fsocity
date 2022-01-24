package com.fsocity.modules.ums.controller;

import com.fsocity.framework.web.JsonResult;
import com.fsocity.modules.ums.model.UmsResourceCategory;
import com.fsocity.modules.ums.service.UmsResourceCategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台资源分类管理Controller
 * Created by macro on 2020/2/5.
 */
@Controller
@Api(tags = "UmsResourceCategoryController", description = "后台资源分类管理")
@RequestMapping("/resourceCategory")
public class UmsResourceCategoryController {
    @Autowired
    private UmsResourceCategoryService resourceCategoryService;
    
    @ApiOperation("查询所有后台资源分类")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult listAll() {
        List<UmsResourceCategory> resourceList = resourceCategoryService.listAll();
        return JsonResult.success(resourceList);
    }
    
    @ApiOperation("添加后台资源分类")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult create(@RequestBody UmsResourceCategory umsResourceCategory) {
        boolean success = resourceCategoryService.create(umsResourceCategory);
        if (success) {
            return JsonResult.success(null);
        }
        else {
            return JsonResult.fail();
        }
    }
    
    @ApiOperation("修改后台资源分类")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult update(@PathVariable Long id,
                             @RequestBody UmsResourceCategory umsResourceCategory) {
        umsResourceCategory.setId(id);
        boolean success = resourceCategoryService.updateById(umsResourceCategory);
        if (success) {
            return JsonResult.success(null);
        }
        else {
            return JsonResult.fail();
        }
    }
    
    @ApiOperation("根据ID删除后台资源")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Long id) {
        boolean success = resourceCategoryService.removeById(id);
        if (success) {
            return JsonResult.success(null);
        }
        else {
            return JsonResult.fail();
        }
    }
}
