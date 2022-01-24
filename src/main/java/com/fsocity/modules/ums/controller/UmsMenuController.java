package com.fsocity.modules.ums.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.framework.web.CommonPage;
import com.fsocity.framework.web.JsonResult;
import com.fsocity.modules.ums.dto.UmsMenuNode;
import com.fsocity.modules.ums.model.UmsMenu;
import com.fsocity.modules.ums.service.UmsMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 后台菜单管理Controller
 * Created by macro on 2020/2/4.
 */
@Controller
@Api(tags = "UmsMenuController", description = "后台菜单管理")
@RequestMapping("/menu")
public class UmsMenuController {
    
    @Autowired
    private UmsMenuService menuService;
    
    @ApiOperation("添加后台菜单")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult create(@RequestBody UmsMenu umsMenu) {
        boolean success = menuService.create(umsMenu);
        if (success) {
            return JsonResult.success(null);
        }
        else {
            return JsonResult.fail();
        }
    }
    
    @ApiOperation("修改后台菜单")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult update(@PathVariable Long id,
                             @RequestBody UmsMenu umsMenu) {
        boolean success = menuService.update(id, umsMenu);
        if (success) {
            return JsonResult.success(null);
        }
        else {
            return JsonResult.fail();
        }
    }
    
    @ApiOperation("根据ID获取菜单详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult getItem(@PathVariable Long id) {
        UmsMenu umsMenu = menuService.getById(id);
        return JsonResult.success(umsMenu);
    }
    
    @ApiOperation("根据ID删除后台菜单")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult delete(@PathVariable Long id) {
        boolean success = menuService.removeById(id);
        if (success) {
            return JsonResult.success(null);
        }
        else {
            return JsonResult.fail();
        }
    }
    
    @ApiOperation("分页查询后台菜单")
    @RequestMapping(value = "/list/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult list(@PathVariable Long parentId,
                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<UmsMenu> menuList = menuService.list(parentId, pageSize, pageNum);
        return JsonResult.success(CommonPage.restPage(menuList));
    }
    
    @ApiOperation("树形结构返回所有菜单列表")
    @RequestMapping(value = "/treeList", method = RequestMethod.GET)
    @ResponseBody
    public JsonResult treeList() {
        List<UmsMenuNode> list = menuService.treeList();
        return JsonResult.success(list);
    }
    
    @ApiOperation("修改菜单显示状态")
    @RequestMapping(value = "/updateHidden/{id}", method = RequestMethod.POST)
    @ResponseBody
    public JsonResult updateHidden(@PathVariable Long id, @RequestParam("hidden") Integer hidden) {
        boolean success = menuService.updateHidden(id, hidden);
        if (success) {
            return JsonResult.success(null);
        }
        else {
            return JsonResult.fail();
        }
    }
}
