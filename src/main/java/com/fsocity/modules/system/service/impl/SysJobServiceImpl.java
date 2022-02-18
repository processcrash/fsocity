package com.fsocity.modules.system.service.impl;

import com.fsocity.modules.system.entity.SysJob;
import com.fsocity.modules.system.mapper.SysJobMapper;
import com.fsocity.modules.system.service.SysJobService;
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
 * @since 2022-02-18
 */
@Service
public class SysJobServiceImpl extends ServiceImpl<SysJobMapper, SysJob> implements SysJobService {
    
    @Autowired
    private SysJobMapper sysJobMapper;
    
    @Override
    public Page<SysJob> findAll(SysJob form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<SysJob> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(SysJob::getId, form.getId());
        }
        
        Page<SysJob> page = new Page<>(pageNum, pageSize);
        page = sysJobMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        SysJob sysJob = new SysJob();
        sysJob.setId(id);
        // sysJob.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  sysJobMapper.updateById(sysJob);
        return num == 1;
    }

}
