package com.fsocity.modules.system.service;

import com.fsocity.modules.system.entity.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
public interface SysMenuService extends IService<SysMenu> {
    
    /**
     * 分页查找
     */
    Page<SysMenu> findAll(SysMenu form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
