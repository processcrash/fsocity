package com.fsocity.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fsocity.modules.system.entity.SysPersistentLogins;
import com.fsocity.modules.system.mapper.SysPersistentLoginsMapper;
import com.fsocity.modules.system.service.SysPersistentLoginsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录持久化表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
@Service
public class SysPersistentLoginsServiceImpl extends ServiceImpl<SysPersistentLoginsMapper, SysPersistentLogins> implements SysPersistentLoginsService {
    
    @Autowired
    private SysPersistentLoginsMapper sysPersistentLoginsMapper;
    
    @Override
    public Page<SysPersistentLogins> findAll(SysPersistentLogins form, Integer pageNum, Integer pageSize) {
        return null;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        return false;
    }
    
}
