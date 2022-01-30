package com.fsocity.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysPosition;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 岗位信息表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
public interface SysPositionService extends IService<SysPosition> {
    
    Page<SysPosition> findAll(Integer pageSize, Integer pageNum);
    
    SysPosition deleteById(Integer id);
}
