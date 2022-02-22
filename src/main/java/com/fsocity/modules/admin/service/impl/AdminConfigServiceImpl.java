package com.fsocity.modules.admin.service.impl;

import com.fsocity.modules.admin.entity.AdminConfig;
import com.fsocity.modules.admin.mapper.AdminConfigMapper;
import com.fsocity.modules.admin.service.AdminConfigService;
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
 * @since 2022-02-22
 */
@Service
public class AdminConfigServiceImpl extends ServiceImpl<AdminConfigMapper, AdminConfig> implements AdminConfigService {
    
    @Autowired
    private AdminConfigMapper adminConfigMapper;
    
    @Override
    public Page<AdminConfig> findAll(AdminConfig form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<AdminConfig> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(AdminConfig::getId, form.getId());
        }
        
        Page<AdminConfig> page = new Page<>(pageNum, pageSize);
        page = adminConfigMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminConfig adminConfig = new AdminConfig();
        adminConfig.setId(id);
        // adminConfig.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  adminConfigMapper.updateById(adminConfig);
        return num == 1;
    }

}
