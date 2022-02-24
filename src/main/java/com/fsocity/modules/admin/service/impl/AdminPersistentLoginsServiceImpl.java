package com.fsocity.modules.admin.service.impl;

import com.fsocity.modules.admin.entity.AdminPersistentLogins;
import com.fsocity.modules.admin.mapper.AdminPersistentLoginsMapper;
import com.fsocity.modules.admin.service.AdminPersistentLoginsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 登录持久化表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-02-24
 */
@Service
public class AdminPersistentLoginsServiceImpl extends ServiceImpl<AdminPersistentLoginsMapper, AdminPersistentLogins> implements AdminPersistentLoginsService {
    
    @Autowired
    private AdminPersistentLoginsMapper adminPersistentLoginsMapper;
    
    @Override
    public Page<AdminPersistentLogins> findAll(AdminPersistentLogins form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<AdminPersistentLogins> queryWrapper = new LambdaQueryWrapper<>();
                if (form.getSeries() != null) {
            queryWrapper.eq(AdminPersistentLogins::getSeries, form.getSeries());
        }
        if (form.getUsername() != null) {
            queryWrapper.eq(AdminPersistentLogins::getUsername, form.getUsername());
        }
        if (form.getToken() != null) {
            queryWrapper.eq(AdminPersistentLogins::getToken, form.getToken());
        }
        if (form.getLastUsed() != null) {
            queryWrapper.eq(AdminPersistentLogins::getLastUsed, form.getLastUsed());
        }
                
        Page<AdminPersistentLogins> page = new Page<>(pageNum, pageSize);
        page = adminPersistentLoginsMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminPersistentLogins adminPersistentLogins = new AdminPersistentLogins();
        adminPersistentLogins.setId(id);
        // adminPersistentLogins.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  adminPersistentLoginsMapper.updateById(adminPersistentLogins);
        return num == 1;
    }

}
