package com.fsocity.modules.admin.service;

import com.fsocity.modules.admin.entity.AdminConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 参数配置表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-21
 */
public interface AdminConfigService extends IService<AdminConfig> {
    
    /**
     * 分页查找
     */
    Page<AdminConfig> findAll(AdminConfig form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
