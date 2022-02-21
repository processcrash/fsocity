package com.fsocity.modules.admin.service;

import com.fsocity.modules.admin.entity.AdminJob;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 定时任务调度表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-21
 */
public interface AdminJobService extends IService<AdminJob> {
    
    /**
     * 分页查找
     */
    Page<AdminJob> findAll(AdminJob form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
