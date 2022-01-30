package com.fsocity.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysConfig;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 参数配置表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
public interface SysConfigService extends IService<SysConfig> {
    
    Page<SysConfig> findAll(Integer pageSize, Integer pageNum);
    
    SysConfig deleteById(Integer id);
    
}
