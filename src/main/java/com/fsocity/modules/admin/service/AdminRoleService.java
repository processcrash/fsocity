package com.fsocity.modules.admin.service;

import com.fsocity.modules.admin.entity.AdminRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-22
 */
public interface AdminRoleService extends IService<AdminRole> {
    
    /**
     * 分页查找
     */
    Page<AdminRole> findAll(AdminRole form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
