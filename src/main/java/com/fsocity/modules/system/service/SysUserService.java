package com.fsocity.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
public interface SysUserService extends IService<SysUser> {
    
    Page<SysUser> findAll(Integer pageSize, Integer pageNum);
    
    SysUser deleteById(Integer id);
    
}
