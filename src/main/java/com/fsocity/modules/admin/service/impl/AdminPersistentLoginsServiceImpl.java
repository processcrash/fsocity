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
 * @since 2022-02-22
 */
@Service
public class AdminPersistentLoginsServiceImpl extends ServiceImpl<AdminPersistentLoginsMapper, AdminPersistentLogins> implements AdminPersistentLoginsService {
    
    @Autowired
    private AdminPersistentLoginsMapper adminPersistentLoginsMapper;
    
    @Override
    public Page<AdminPersistentLogins> findAll(AdminPersistentLogins form, Integer pageNum, Integer pageSize) {
        return null;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        return false;
    }

}
