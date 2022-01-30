package com.fsocity.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysRole;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色信息表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
public interface SysRoleService extends IService<SysRole> {
    
    Page<SysRole> findAll(Integer pageSize, Integer pageNum);
    
    SysRole deleteById(Integer id);
    
}
