package com.fsocity.modules.system.service;

import com.fsocity.modules.system.entity.SysRoleDepartment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 角色和部门关联表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
public interface SysRoleDepartmentService extends IService<SysRoleDepartment> {
    
    /**
     * 分页查找
     */
    Page<SysRoleDepartment> findAll(SysRoleDepartment form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
