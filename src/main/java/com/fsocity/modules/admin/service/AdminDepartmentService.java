package com.fsocity.modules.admin.service;

import com.fsocity.modules.admin.entity.AdminDepartment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-21
 */
public interface AdminDepartmentService extends IService<AdminDepartment> {
    
    /**
     * 分页查找
     */
    Page<AdminDepartment> findAll(AdminDepartment form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
