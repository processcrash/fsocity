package com.fsocity.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysPersistentLogins;
import com.fsocity.modules.system.mapper.SysPersistentLoginsMapper;
import com.fsocity.modules.system.service.SysPersistentLoginsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 登录持久化表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Service
public class SysPersistentLoginsServiceImpl extends ServiceImpl<SysPersistentLoginsMapper, SysPersistentLogins> implements SysPersistentLoginsService {
    
    @Override
    public Page<SysPersistentLogins> findAll(Integer pageSize, Integer pageNum) {
        return null;
    }
    
    @Override
    public SysPersistentLogins deleteById(Integer id) {
        return null;
    }
}
