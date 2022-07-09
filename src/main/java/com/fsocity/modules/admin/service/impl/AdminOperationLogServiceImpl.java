package com.fsocity.modules.admin.service.impl;

import com.fsocity.modules.admin.entity.AdminOperationLog;
import com.fsocity.modules.admin.mapper.AdminOperationLogMapper;
import com.fsocity.modules.admin.service.AdminOperationLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-07-07
 */
@Service
public class AdminOperationLogServiceImpl extends ServiceImpl<AdminOperationLogMapper, AdminOperationLog> implements AdminOperationLogService {
    
    @Autowired
    private AdminOperationLogMapper adminOperationLogMapper;
    
    @Override
    public Page<AdminOperationLog> findAll(AdminOperationLog form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<AdminOperationLog> queryWrapper = new LambdaQueryWrapper<>();
                if (form.getId() != null) {
            queryWrapper.eq(AdminOperationLog::getId, form.getId());
        }
        if (form.getTitle() != null) {
            queryWrapper.eq(AdminOperationLog::getTitle, form.getTitle());
        }
        if (form.getBusinessType() != null) {
            queryWrapper.eq(AdminOperationLog::getBusinessType, form.getBusinessType());
        }
        if (form.getMethod() != null) {
            queryWrapper.eq(AdminOperationLog::getMethod, form.getMethod());
        }
        if (form.getRequestMethod() != null) {
            queryWrapper.eq(AdminOperationLog::getRequestMethod, form.getRequestMethod());
        }
        if (form.getOperatorType() != null) {
            queryWrapper.eq(AdminOperationLog::getOperatorType, form.getOperatorType());
        }
        if (form.getOperatorName() != null) {
            queryWrapper.eq(AdminOperationLog::getOperatorName, form.getOperatorName());
        }
        if (form.getDepartmentName() != null) {
            queryWrapper.eq(AdminOperationLog::getDepartmentName, form.getDepartmentName());
        }
        if (form.getUrl() != null) {
            queryWrapper.eq(AdminOperationLog::getUrl, form.getUrl());
        }
        if (form.getIp() != null) {
            queryWrapper.eq(AdminOperationLog::getIp, form.getIp());
        }
        if (form.getLocation() != null) {
            queryWrapper.eq(AdminOperationLog::getLocation, form.getLocation());
        }
        if (form.getParam() != null) {
            queryWrapper.eq(AdminOperationLog::getParam, form.getParam());
        }
        if (form.getResult() != null) {
            queryWrapper.eq(AdminOperationLog::getResult, form.getResult());
        }
        if (form.getStatus() != null) {
            queryWrapper.eq(AdminOperationLog::getStatus, form.getStatus());
        }
        if (form.getErrorMsg() != null) {
            queryWrapper.eq(AdminOperationLog::getErrorMsg, form.getErrorMsg());
        }
        if (form.getOperationTime() != null) {
            queryWrapper.eq(AdminOperationLog::getOperationTime, form.getOperationTime());
        }
                
        Page<AdminOperationLog> page = new Page<>(pageNum, pageSize);
        return this.page(page, queryWrapper);
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminOperationLog adminOperationLog = new AdminOperationLog();
        adminOperationLog.setId(id);
        // adminOperationLog.setStatus(DeleteStatusEnum.DELETED.getCode());
        return this.updateById(adminOperationLog);
    }

}
