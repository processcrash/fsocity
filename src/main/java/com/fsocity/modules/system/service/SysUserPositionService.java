package com.fsocity.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysUserPosition;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户与岗位关联表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
public interface SysUserPositionService extends IService<SysUserPosition> {
    
    Page<SysUserPosition> findAll(Integer pageSize, Integer pageNum);
    
    SysUserPosition deleteById(Integer id);
    
}
