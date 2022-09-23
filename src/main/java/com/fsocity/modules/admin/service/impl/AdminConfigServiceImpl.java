package com.fsocity.modules.admin.service.impl;

import com.fsocity.modules.admin.bo.AdminConfigBO;
import com.fsocity.modules.admin.entity.AdminConfig;
import com.fsocity.modules.admin.mapper.AdminConfigMapper;
import com.fsocity.modules.admin.service.AdminConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.data.domain.PageRequest;
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
 * @since 2022-07-07
 */
@Service
public class AdminConfigServiceImpl extends ServiceImpl<AdminConfigMapper, AdminConfig> implements AdminConfigService {
    
    @Autowired
    private AdminConfigMapper adminConfigMapper;
    
    @Override
    public Page<AdminConfig> findAll(PageRequest page, AdminConfigBO bo) {
        return null;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminConfig adminConfig = new AdminConfig();
        adminConfig.setId(id);
        // adminConfig.setStatus(DeleteStatusEnum.DELETED.getCode());
        return this.updateById(adminConfig);
    }

}
