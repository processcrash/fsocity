package com.fsocity.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysJob;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 定时任务调度表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
public interface SysJobService extends IService<SysJob> {
    
    Page<SysJob> findAll(Integer pageSize, Integer pageNum);
    
    SysJob deleteById(Integer id);
    
}
