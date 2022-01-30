package com.fsocity.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户和角色关联表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
public interface SysUserRoleService extends IService<SysUserRole> {
    
    Page<SysUserRole> findAll(Integer pageSize, Integer pageNum);
    
    SysUserRole deleteById(Integer id);
    
}
