package com.fsocity.modules.ums.controller;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.common.api.CommonPage;
import com.fsocity.common.api.JsonResult;
import com.fsocity.common.api.ResponseStatusEnum;
import com.fsocity.modules.ums.dto.UmsAdminLoginParam;
import com.fsocity.modules.ums.dto.UmsAdminParam;
import com.fsocity.modules.ums.dto.UpdateAdminPasswordParam;
import com.fsocity.modules.ums.model.UmsAdmin;
import com.fsocity.modules.ums.model.UmsRole;
import com.fsocity.modules.ums.service.UmsAdminService;
import com.fsocity.modules.ums.service.UmsRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 后台用户管理
 * Created by macro on 2018/4/26.
 */
@RestController
@RequestMapping("/admin")
@Api(tags = "UmsAdminController", description = "后台用户管理")
public class UmsAdminController {
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private UmsAdminService adminService;
    @Autowired
    private UmsRoleService roleService;
    
    @ApiOperation(value = "用户注册")
    @PostMapping("/register")
    public JsonResult register(@Validated @RequestBody UmsAdminParam umsAdminParam) {
        UmsAdmin umsAdmin = adminService.register(umsAdminParam);
        if (umsAdmin == null) {
            return JsonResult.fail();
        }
        return JsonResult.success(umsAdmin);
    }
    
    @ApiOperation(value = "登录以后返回token")
    @PostMapping("/login")
    public JsonResult login(@Validated @RequestBody UmsAdminLoginParam umsAdminLoginParam) {
        String token = adminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());
        if (token == null) {
            return JsonResult.fail(
                    ResponseStatusEnum.VALIDATE_FAILED.getCode(),
                    ResponseStatusEnum.VALIDATE_FAILED.getMessage() + "用户名或密码错误！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return JsonResult.success(tokenMap);
    }
    
    @ApiOperation(value = "刷新token")
    @GetMapping("/refreshToken")
    public JsonResult refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = adminService.refreshToken(token);
        if (refreshToken == null) {
            return JsonResult.fail("token已经过期！");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return JsonResult.success(tokenMap);
    }
    
    @ApiOperation(value = "获取当前登录用户信息")
    @GetMapping("/info")
    public JsonResult getAdminInfo(Principal principal) {
        if (principal == null) {
            return JsonResult.fail(ResponseStatusEnum.UNAUTHORIZED);
        }
        String username = principal.getName();
        UmsAdmin umsAdmin = adminService.getAdminByUsername(username);
        Map<String, Object> data = new HashMap<>();
        data.put("username", umsAdmin.getUsername());
        data.put("menus", roleService.getMenuList(umsAdmin.getId()));
        data.put("icon", umsAdmin.getIcon());
        List<UmsRole> roleList = adminService.getRoleList(umsAdmin.getId());
        if (CollUtil.isNotEmpty(roleList)) {
            List<String> roles = roleList.stream().map(UmsRole::getName).collect(Collectors.toList());
            data.put("roles", roles);
        }
        return JsonResult.success(data);
    }
    
    @ApiOperation(value = "登出功能")
    @PostMapping("/logout")
    public JsonResult logout() {
        return JsonResult.success();
    }
    
    @ApiOperation("根据用户名或姓名分页获取用户列表")
    @GetMapping("/list")
    public JsonResult list(@RequestParam(value = "keyword", required = false) String keyword,
                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page<UmsAdmin> adminList = adminService.list(keyword, pageSize, pageNum);
        return JsonResult.success(CommonPage.restPage(adminList));
    }
    
    @ApiOperation("获取指定用户信息")
    @GetMapping("/{id}")
    public JsonResult getItem(@PathVariable Long id) {
        UmsAdmin admin = adminService.getById(id);
        return JsonResult.success(admin);
    }
    
    @ApiOperation("修改指定用户信息")
    @PostMapping("/update/{id}")
    public JsonResult update(@PathVariable Long id, @RequestBody UmsAdmin admin) {
        boolean success = adminService.update(id, admin);
        if (success) {
            return JsonResult.success(null);
        }
        return JsonResult.fail();
    }
    
    @ApiOperation("修改指定用户密码")
    @PostMapping("/updatePassword")
    public JsonResult updatePassword(@Validated @RequestBody UpdateAdminPasswordParam updatePasswordParam) {
        int status = adminService.updatePassword(updatePasswordParam);
        if (status > 0) {
            return JsonResult.success(status);
        }
        else if (status == -1) {
            return JsonResult.fail("提交参数不合法");
        }
        else if (status == -2) {
            return JsonResult.fail("找不到该用户");
        }
        else if (status == -3) {
            return JsonResult.fail("旧密码错误");
        }
        else {
            return JsonResult.fail();
        }
    }
    
    @ApiOperation("删除指定用户信息")
    @PostMapping("/delete/{id}")
    public JsonResult delete(@PathVariable Long id) {
        boolean success = adminService.delete(id);
        if (success) {
            return JsonResult.success(null);
        }
        return JsonResult.fail();
    }
    
    @ApiOperation("修改帐号状态")
    @PostMapping("/updateStatus/{id}")
    public JsonResult updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setStatus(status);
        boolean success = adminService.update(id, umsAdmin);
        if (success) {
            return JsonResult.success(null);
        }
        return JsonResult.fail();
    }
    
    @ApiOperation("给用户分配角色")
    @PostMapping("/role/update")
    public JsonResult updateRole(@RequestParam("adminId") Long adminId,
                                 @RequestParam("roleIds") List<Long> roleIds) {
        int count = adminService.updateRole(adminId, roleIds);
        if (count < 0) {
            return JsonResult.err();
        }
        return JsonResult.ok(count);
    }
    
    @ApiOperation("获取指定用户的角色")
    @GetMapping("/role/{adminId}")
    public JsonResult getRoleList(@PathVariable Long adminId) {
        List<UmsRole> roleList = adminService.getRoleList(adminId);
        return JsonResult.success(roleList);
    }
}
