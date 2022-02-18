package com.fsocity.modules.system.service.impl;

import com.fsocity.modules.system.entity.SysOperationLog;
import com.fsocity.modules.system.mapper.SysOperationLogMapper;
import com.fsocity.modules.system.service.SysOperationLogService;
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
 * @since 2022-02-18
 */
@Service
public class SysOperationLogServiceImpl extends ServiceImpl<SysOperationLogMapper, SysOperationLog> implements SysOperationLogService {
    
    @Autowired
    private SysOperationLogMapper sysOperationLogMapper;
    
    @Override
    public Page<SysOperationLog> findAll(SysOperationLog form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<SysOperationLog> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(SysOperationLog::getId, form.getId());
        }
        
        Page<SysOperationLog> page = new Page<>(pageNum, pageSize);
        page = sysOperationLogMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        SysOperationLog sysOperationLog = new SysOperationLog();
        sysOperationLog.setId(id);
        // sysOperationLog.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  sysOperationLogMapper.updateById(sysOperationLog);
        return num == 1;
    }

}
