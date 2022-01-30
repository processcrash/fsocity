package com.fsocity.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysJob;
import com.fsocity.modules.system.mapper.SysJobMapper;
import com.fsocity.modules.system.service.SysJobService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 定时任务调度表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Service
public class SysJobServiceImpl extends ServiceImpl<SysJobMapper, SysJob> implements SysJobService {
    
    @Override
    public Page<SysJob> findAll(Integer pageSize, Integer pageNum) {
        return null;
    }
    
    @Override
    public SysJob deleteById(Integer id) {
        return null;
    }
}
