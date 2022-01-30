package com.fsocity.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysJobLog;
import com.fsocity.modules.system.mapper.SysJobLogMapper;
import com.fsocity.modules.system.service.SysJobLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务调度日志表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Service
public class SysJobLogServiceImpl extends ServiceImpl<SysJobLogMapper, SysJobLog> implements SysJobLogService {
    
    @Override
    public Page<SysJobLog> findAll(Integer pageSize, Integer pageNum) {
        return null;
    }
    
    @Override
    public SysJobLog deleteById(Integer id) {
        return null;
    }
}
