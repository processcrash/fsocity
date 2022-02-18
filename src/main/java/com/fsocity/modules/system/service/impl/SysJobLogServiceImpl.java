package com.fsocity.modules.system.service.impl;

import com.fsocity.modules.system.entity.SysJobLog;
import com.fsocity.modules.system.mapper.SysJobLogMapper;
import com.fsocity.modules.system.service.SysJobLogService;
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
 * @since 2022-02-18
 */
@Service
public class SysJobLogServiceImpl extends ServiceImpl<SysJobLogMapper, SysJobLog> implements SysJobLogService {
    
    @Autowired
    private SysJobLogMapper sysJobLogMapper;
    
    @Override
    public Page<SysJobLog> findAll(SysJobLog form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<SysJobLog> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(SysJobLog::getId, form.getId());
        }
        
        Page<SysJobLog> page = new Page<>(pageNum, pageSize);
        page = sysJobLogMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        SysJobLog sysJobLog = new SysJobLog();
        sysJobLog.setId(id);
        // sysJobLog.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  sysJobLogMapper.updateById(sysJobLog);
        return num == 1;
    }

}
