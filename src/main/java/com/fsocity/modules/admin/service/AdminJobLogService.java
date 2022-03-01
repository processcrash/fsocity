package com.fsocity.modules.admin.service;

import com.fsocity.modules.admin.entity.AdminJobLog;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 定时任务调度日志表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-03-02
 */
public interface AdminJobLogService extends IService<AdminJobLog> {
    
    /**
     * 分页查找
     */
    Page<AdminJobLog> findAll(AdminJobLog form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
