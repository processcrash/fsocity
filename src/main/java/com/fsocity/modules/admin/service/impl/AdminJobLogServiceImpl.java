package com.fsocity.modules.admin.service.impl;

import com.fsocity.modules.admin.entity.AdminJobLog;
import com.fsocity.modules.admin.mapper.AdminJobLogMapper;
import com.fsocity.modules.admin.service.AdminJobLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 定时任务调度日志表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-03-02
 */
@Service
public class AdminJobLogServiceImpl extends ServiceImpl<AdminJobLogMapper, AdminJobLog> implements AdminJobLogService {
    
    @Autowired
    private AdminJobLogMapper adminJobLogMapper;
    
    @Override
    public Page<AdminJobLog> findAll(AdminJobLog form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<AdminJobLog> queryWrapper = new LambdaQueryWrapper<>();
                if (form.getId() != null) {
            queryWrapper.eq(AdminJobLog::getId, form.getId());
        }
        if (form.getGroup() != null) {
            queryWrapper.eq(AdminJobLog::getGroup, form.getGroup());
        }
        if (form.getName() != null) {
            queryWrapper.eq(AdminJobLog::getName, form.getName());
        }
        if (form.getInvokeTarget() != null) {
            queryWrapper.eq(AdminJobLog::getInvokeTarget, form.getInvokeTarget());
        }
        if (form.getJobMessage() != null) {
            queryWrapper.eq(AdminJobLog::getJobMessage, form.getJobMessage());
        }
        if (form.getStatus() != null) {
            queryWrapper.eq(AdminJobLog::getStatus, form.getStatus());
        }
        if (form.getExceptionInfo() != null) {
            queryWrapper.eq(AdminJobLog::getExceptionInfo, form.getExceptionInfo());
        }
        if (form.getCreateTime() != null) {
            queryWrapper.eq(AdminJobLog::getCreateTime, form.getCreateTime());
        }
                
        Page<AdminJobLog> page = new Page<>(pageNum, pageSize);
        return this.page(page, queryWrapper);
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminJobLog adminJobLog = new AdminJobLog();
        adminJobLog.setId(id);
        // adminJobLog.setStatus(DeleteStatusEnum.DELETED.getCode());
        return this.updateById(adminJobLog);
    }

}
