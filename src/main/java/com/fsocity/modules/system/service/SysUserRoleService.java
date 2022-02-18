package com.fsocity.modules.system.service;

import com.fsocity.modules.system.entity.SysUserRole;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 用户和角色关联表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
public interface SysUserRoleService extends IService<SysUserRole> {
    
    /**
     * 分页查找
     */
    Page<SysUserRole> findAll(SysUserRole form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
