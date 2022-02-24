package com.fsocity.modules.admin.service.impl;

import com.fsocity.modules.admin.entity.AdminNotice;
import com.fsocity.modules.admin.mapper.AdminNoticeMapper;
import com.fsocity.modules.admin.service.AdminNoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 通知公告表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-02-24
 */
@Service
public class AdminNoticeServiceImpl extends ServiceImpl<AdminNoticeMapper, AdminNotice> implements AdminNoticeService {
    
    @Autowired
    private AdminNoticeMapper adminNoticeMapper;
    
    @Override
    public Page<AdminNotice> findAll(AdminNotice form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<AdminNotice> queryWrapper = new LambdaQueryWrapper<>();
                if (form.getId() != null) {
            queryWrapper.eq(AdminNotice::getId, form.getId());
        }
        if (form.getType() != null) {
            queryWrapper.eq(AdminNotice::getType, form.getType());
        }
        if (form.getTitle() != null) {
            queryWrapper.eq(AdminNotice::getTitle, form.getTitle());
        }
        if (form.getContent() != null) {
            queryWrapper.eq(AdminNotice::getContent, form.getContent());
        }
        if (form.getRemark() != null) {
            queryWrapper.eq(AdminNotice::getRemark, form.getRemark());
        }
        if (form.getStatus() != null) {
            queryWrapper.eq(AdminNotice::getStatus, form.getStatus());
        }
        if (form.getCreateBy() != null) {
            queryWrapper.eq(AdminNotice::getCreateBy, form.getCreateBy());
        }
        if (form.getCreateTime() != null) {
            queryWrapper.eq(AdminNotice::getCreateTime, form.getCreateTime());
        }
        if (form.getUpdateBy() != null) {
            queryWrapper.eq(AdminNotice::getUpdateBy, form.getUpdateBy());
        }
        if (form.getUpdateTime() != null) {
            queryWrapper.eq(AdminNotice::getUpdateTime, form.getUpdateTime());
        }
                
        Page<AdminNotice> page = new Page<>(pageNum, pageSize);
        page = adminNoticeMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminNotice adminNotice = new AdminNotice();
        adminNotice.setId(id);
        // adminNotice.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  adminNoticeMapper.updateById(adminNotice);
        return num == 1;
    }

}
