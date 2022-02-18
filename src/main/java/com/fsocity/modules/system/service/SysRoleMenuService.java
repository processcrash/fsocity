package com.fsocity.modules.system.service;

import com.fsocity.modules.system.entity.SysRoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 角色和菜单关联表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {
    
    /**
     * 分页查找
     */
    Page<SysRoleMenu> findAll(SysRoleMenu form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
