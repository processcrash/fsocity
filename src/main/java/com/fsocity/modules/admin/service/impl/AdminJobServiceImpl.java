package com.fsocity.modules.admin.service.impl;

import com.fsocity.modules.admin.entity.AdminJob;
import com.fsocity.modules.admin.mapper.AdminJobMapper;
import com.fsocity.modules.admin.service.AdminJobService;
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
 * @since 2022-02-22
 */
@Service
public class AdminJobServiceImpl extends ServiceImpl<AdminJobMapper, AdminJob> implements AdminJobService {
    
    @Autowired
    private AdminJobMapper adminJobMapper;
    
    @Override
    public Page<AdminJob> findAll(AdminJob form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<AdminJob> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(AdminJob::getId, form.getId());
        }
        
        Page<AdminJob> page = new Page<>(pageNum, pageSize);
        page = adminJobMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminJob adminJob = new AdminJob();
        adminJob.setId(id);
        // adminJob.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  adminJobMapper.updateById(adminJob);
        return num == 1;
    }

}
