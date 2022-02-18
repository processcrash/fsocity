package com.fsocity.modules.system.service;

import com.fsocity.modules.system.entity.SysPersistentLogins;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 登录持久化表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
public interface SysPersistentLoginsService extends IService<SysPersistentLogins> {
    
    /**
     * 分页查找
     */
    Page<SysPersistentLogins> findAll(SysPersistentLogins form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
