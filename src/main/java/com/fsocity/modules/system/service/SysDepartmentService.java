package com.fsocity.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysDepartment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
public interface SysDepartmentService extends IService<SysDepartment> {
    
    Page<SysDepartment> findAll(Integer pageSize, Integer pageNum);
    
    SysDepartment deleteById(Integer id);
    
}
