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
 * @since 2022-02-22
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
        
        Page<AdminJobLog> page = new Page<>(pageNum, pageSize);
        page = adminJobLogMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminJobLog adminJobLog = new AdminJobLog();
        adminJobLog.setId(id);
        // adminJobLog.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  adminJobLogMapper.updateById(adminJobLog);
        return num == 1;
    }

}
