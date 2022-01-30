package com.fsocity.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
public interface SysMenuService extends IService<SysMenu> {
    
    Page<SysMenu> findAll(Integer pageSize, Integer pageNum);
    
    SysMenu deleteById(Integer id);
    
}
