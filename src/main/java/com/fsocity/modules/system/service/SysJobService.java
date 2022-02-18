package com.fsocity.modules.system.service;

import com.fsocity.modules.system.entity.SysJob;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 定时任务调度表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
public interface SysJobService extends IService<SysJob> {
    
    /**
     * 分页查找
     */
    Page<SysJob> findAll(SysJob form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
