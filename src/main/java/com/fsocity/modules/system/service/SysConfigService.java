package com.fsocity.modules.system.service;

import com.fsocity.modules.system.entity.SysConfig;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 参数配置表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
public interface SysConfigService extends IService<SysConfig> {
    
    /**
     * 分页查找
     */
    Page<SysConfig> findAll(SysConfig form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
