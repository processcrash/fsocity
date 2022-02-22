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
 * @since 2022-02-22
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
        
        Page<AdminOperationLog> page = new Page<>(pageNum, pageSize);
        page = adminOperationLogMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminOperationLog adminOperationLog = new AdminOperationLog();
        adminOperationLog.setId(id);
        // adminOperationLog.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  adminOperationLogMapper.updateById(adminOperationLog);
        return num == 1;
    }

}
