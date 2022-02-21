package com.fsocity.modules.admin.service;

import com.fsocity.modules.admin.entity.AdminRoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 角色和菜单关联表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-21
 */
public interface AdminRoleMenuService extends IService<AdminRoleMenu> {
    
    /**
     * 分页查找
     */
    Page<AdminRoleMenu> findAll(AdminRoleMenu form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
