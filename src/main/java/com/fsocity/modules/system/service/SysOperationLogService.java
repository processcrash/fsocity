package com.fsocity.modules.system.service;

import com.fsocity.modules.system.entity.SysOperationLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 操作日志记录 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
public interface SysOperationLogService extends IService<SysOperationLog> {
    
    /**
     * 分页查找
     */
    Page<SysOperationLog> findAll(SysOperationLog form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
