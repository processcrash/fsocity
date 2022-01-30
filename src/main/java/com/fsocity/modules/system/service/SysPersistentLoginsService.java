package com.fsocity.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysPersistentLogins;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 登录持久化表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
public interface SysPersistentLoginsService extends IService<SysPersistentLogins> {
    
    Page<SysPersistentLogins> findAll(Integer pageSize, Integer pageNum);
    
    SysPersistentLogins deleteById(Integer id);
    
}
