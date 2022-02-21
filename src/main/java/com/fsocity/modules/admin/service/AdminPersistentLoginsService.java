package com.fsocity.modules.admin.service;

import com.fsocity.modules.admin.entity.AdminPersistentLogins;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 登录持久化表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-21
 */
public interface AdminPersistentLoginsService extends IService<AdminPersistentLogins> {
    
    /**
     * 分页查找
     */
    Page<AdminPersistentLogins> findAll(AdminPersistentLogins form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
