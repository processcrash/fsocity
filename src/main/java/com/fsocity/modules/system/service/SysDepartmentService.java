package com.fsocity.modules.system.service;

import com.fsocity.modules.system.entity.SysDepartment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 部门表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
public interface SysDepartmentService extends IService<SysDepartment> {
    
    /**
     * 分页查找
     */
    Page<SysDepartment> findAll(SysDepartment form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
