package com.fsocity.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysRoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色和菜单关联表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
public interface SysRoleMenuService extends IService<SysRoleMenu> {
    
    Page<SysRoleMenu> findAll(Integer pageSize, Integer pageNum);
    
    SysRoleMenu deleteById(Integer id);
    
}
