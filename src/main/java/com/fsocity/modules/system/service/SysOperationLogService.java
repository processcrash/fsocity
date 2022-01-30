package com.fsocity.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysOperationLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 操作日志记录 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
public interface SysOperationLogService extends IService<SysOperationLog> {
    
    Page<SysOperationLog> findAll(Integer pageSize, Integer pageNum);
    
    SysOperationLog deleteById(Integer id);
    
}
