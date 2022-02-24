package com.fsocity.modules.admin.service;

import com.fsocity.modules.admin.entity.AdminOperationLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 操作日志记录 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-24
 */
public interface AdminOperationLogService extends IService<AdminOperationLog> {
    
    /**
     * 分页查找
     */
    Page<AdminOperationLog> findAll(AdminOperationLog form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
