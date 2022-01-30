package com.fsocity.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysRoleDepartment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色和部门关联表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
public interface SysRoleDepartmentService extends IService<SysRoleDepartment> {
    
    Page<SysRoleDepartment> findAll(Integer pageSize, Integer pageNum);
    
    SysRoleDepartment deleteById(Integer id);
    
}
