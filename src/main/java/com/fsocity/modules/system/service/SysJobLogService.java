package com.fsocity.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysJobLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 定时任务调度日志表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
public interface SysJobLogService extends IService<SysJobLog> {
    
    Page<SysJobLog> findAll(Integer pageSize, Integer pageNum);
    
    SysJobLog deleteById(Integer id);
    
}
