package com.fsocity.modules.admin.service;

import com.fsocity.modules.admin.entity.AdminUserPosition;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 用户与岗位关联表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-21
 */
public interface AdminUserPositionService extends IService<AdminUserPosition> {
    
    /**
     * 分页查找
     */
    Page<AdminUserPosition> findAll(AdminUserPosition form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
