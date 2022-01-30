package com.fsocity.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysOperationLog;
import com.fsocity.modules.system.mapper.SysOperationLogMapper;
import com.fsocity.modules.system.service.SysOperationLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Service
public class SysOperationLogServiceImpl extends ServiceImpl<SysOperationLogMapper, SysOperationLog> implements SysOperationLogService {
    
    @Override
    public Page<SysOperationLog> findAll(Integer pageSize, Integer pageNum) {
        return null;
    }
    
    @Override
    public SysOperationLog deleteById(Integer id) {
        return null;
    }
}
