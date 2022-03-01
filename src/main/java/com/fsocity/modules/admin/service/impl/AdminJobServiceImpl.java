package com.fsocity.modules.admin.service.impl;

import com.fsocity.modules.admin.entity.AdminJob;
import com.fsocity.modules.admin.mapper.AdminJobMapper;
import com.fsocity.modules.admin.service.AdminJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 定时任务调度表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-03-02
 */
@Service
public class AdminJobServiceImpl extends ServiceImpl<AdminJobMapper, AdminJob> implements AdminJobService {
    
    @Autowired
    private AdminJobMapper adminJobMapper;
    
    @Override
    public Page<AdminJob> findAll(AdminJob form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<AdminJob> queryWrapper = new LambdaQueryWrapper<>();
                if (form.getId() != null) {
            queryWrapper.eq(AdminJob::getId, form.getId());
        }
        if (form.getGroup() != null) {
            queryWrapper.eq(AdminJob::getGroup, form.getGroup());
        }
        if (form.getName() != null) {
            queryWrapper.eq(AdminJob::getName, form.getName());
        }
        if (form.getInvokeTarget() != null) {
            queryWrapper.eq(AdminJob::getInvokeTarget, form.getInvokeTarget());
        }
        if (form.getCronExpression() != null) {
            queryWrapper.eq(AdminJob::getCronExpression, form.getCronExpression());
        }
        if (form.getMisfirePolicy() != null) {
            queryWrapper.eq(AdminJob::getMisfirePolicy, form.getMisfirePolicy());
        }
        if (form.getConcurrent() != null) {
            queryWrapper.eq(AdminJob::getConcurrent, form.getConcurrent());
        }
        if (form.getRemark() != null) {
            queryWrapper.eq(AdminJob::getRemark, form.getRemark());
        }
        if (form.getStatus() != null) {
            queryWrapper.eq(AdminJob::getStatus, form.getStatus());
        }
        if (form.getCreateBy() != null) {
            queryWrapper.eq(AdminJob::getCreateBy, form.getCreateBy());
        }
        if (form.getCreateTime() != null) {
            queryWrapper.eq(AdminJob::getCreateTime, form.getCreateTime());
        }
        if (form.getUpdateBy() != null) {
            queryWrapper.eq(AdminJob::getUpdateBy, form.getUpdateBy());
        }
        if (form.getUpdateTime() != null) {
            queryWrapper.eq(AdminJob::getUpdateTime, form.getUpdateTime());
        }
                
        Page<AdminJob> page = new Page<>(pageNum, pageSize);
        return this.page(page, queryWrapper);
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminJob adminJob = new AdminJob();
        adminJob.setId(id);
        // adminJob.setStatus(DeleteStatusEnum.DELETED.getCode());
        return this.updateById(adminJob);
    }

}
