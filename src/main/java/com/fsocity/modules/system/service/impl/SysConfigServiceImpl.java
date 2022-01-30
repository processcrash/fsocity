package com.fsocity.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysConfig;
import com.fsocity.modules.system.mapper.SysConfigMapper;
import com.fsocity.modules.system.service.SysConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements SysConfigService {
    
    @Override
    public Page<SysConfig> findAll(Integer pageSize, Integer pageNum) {
        return null;
    }
    
    @Override
    public SysConfig deleteById(Integer id) {
        return null;
    }
}
