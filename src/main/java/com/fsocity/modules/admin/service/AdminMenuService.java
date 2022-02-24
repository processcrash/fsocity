package com.fsocity.modules.admin.service;

import com.fsocity.modules.admin.entity.AdminMenu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-24
 */
public interface AdminMenuService extends IService<AdminMenu> {
    
    /**
     * 分页查找
     */
    Page<AdminMenu> findAll(AdminMenu form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
