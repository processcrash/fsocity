package com.fsocity.modules.system.service.impl;

import com.fsocity.modules.system.entity.SysConfig;
import com.fsocity.modules.system.mapper.SysConfigMapper;
import com.fsocity.modules.system.service.SysConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 参数配置表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements SysConfigService {
    
    @Autowired
    private SysConfigMapper sysConfigMapper;
    
    @Override
    public Page<SysConfig> findAll(SysConfig form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<SysConfig> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(SysConfig::getId, form.getId());
        }
        
        Page<SysConfig> page = new Page<>(pageNum, pageSize);
        page = sysConfigMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        SysConfig sysConfig = new SysConfig();
        sysConfig.setId(id);
        // sysConfig.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  sysConfigMapper.updateById(sysConfig);
        return num == 1;
    }

}
