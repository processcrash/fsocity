package com.fsocity.modules.admin.service;

import com.fsocity.modules.admin.entity.AdminUserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 用户和角色关联表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-24
 */
public interface AdminUserRoleService extends IService<AdminUserRole> {
    
    /**
     * 分页查找
     */
    Page<AdminUserRole> findAll(AdminUserRole form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
