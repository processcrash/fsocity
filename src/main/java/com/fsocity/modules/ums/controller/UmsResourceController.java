package com.fsocity.modules.ums.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.framework.web.CommonPage;
import com.fsocity.framework.web.JsonResult;
import com.fsocity.modules.ums.model.UmsResource;
import com.fsocity.modules.ums.service.UmsResourceService;
import com.fsocity.framework.security.component.DynamicSecurityMetadataSource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台资源管理Controller
 * Created by macro on 2020/2/4.
 */
@Controller
@Api(tags = "UmsResourceController", description = "后台资源管理")
@RequestMapping("/resource")
public class UmsResourceController {

    @Autowired
    private UmsResourceService resourceService;
    @Autowired
    private DynamicSecurityMetadataSource dynamicSecurityMetadataSource;

    @ApiOperation("添加后台资源")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult create(@RequestBody UmsResource umsResource) {
        boolean success = resourceService.create(umsResource);
        dynamicSecurityMetadataSource.clearDataSource();
        if (success) {
            return JsonResult.success(null);
        } else {
            return JsonResult.fail();
        }
    }

    @ApiOperation("修改后台资源")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult update(@PathVariable Long id,
                               @RequestBody UmsResource umsResource) {
        boolean success = resourceService.update(id, umsResource);
        dynamicSecurityMetadataSource.clearDataSource();
        if (success) {
            return JsonResult.success(null);
        } else {
            return JsonResult.fail();
        }
    }

    @ApiOperation("根据ID获取资源详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getItem(@PathVariable Long id) {
        UmsResource umsResource = resourceService.getById(id);
        return JsonResult.success(umsResource);
    }

    @ApiOperation("根据ID删除后台资源")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Long id) {
        boolean success = resourceService.delete(id);
        dynamicSecurityMetadataSource.clearDataSource();
        if (success) {
            return JsonResult.success(null);
        } else {
            return JsonResult.fail();
        }
    }

    @ApiOperation("分页模糊查询后台资源")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult list(@RequestParam(required = false) Long categoryId,
                                                      @RequestParam(required = false) String nameKeyword,
                                                      @RequestParam(required = false) String urlKeyword,
                                                      @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                                      @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<UmsResource> resourceList = resourceService.list(categoryId,nameKeyword, urlKeyword, pageSize, pageNum);
        return JsonResult.success(CommonPage.restPage(resourceList));
    }

    @ApiOperation("查询所有后台资源")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult listAll() {
        List<UmsResource> resourceList = resourceService.list();
        return JsonResult.success(resourceList);
    }
}
