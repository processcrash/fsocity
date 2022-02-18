package com.fsocity.modules.system.service;

import com.fsocity.modules.system.entity.SysUserPosition;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 用户与岗位关联表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
public interface SysUserPositionService extends IService<SysUserPosition> {
    
    /**
     * 分页查找
     */
    Page<SysUserPosition> findAll(SysUserPosition form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
