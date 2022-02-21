package com.fsocity.modules.admin.service;

import com.fsocity.modules.admin.entity.AdminPosition;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 岗位信息表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-21
 */
public interface AdminPositionService extends IService<AdminPosition> {
    
    /**
     * 分页查找
     */
    Page<AdminPosition> findAll(AdminPosition form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
