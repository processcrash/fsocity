package com.fsocity.modules.system.service;

import com.fsocity.modules.system.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
public interface SysUserService extends IService<SysUser> {
    
    /**
     * 分页查找
     */
    Page<SysUser> findAll(SysUser form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
