package com.fsocity.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysUserRole;
import com.fsocity.modules.system.mapper.SysUserRoleMapper;
import com.fsocity.modules.system.service.SysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
    
    @Override
    public Page<SysUserRole> findAll(Integer pageSize, Integer pageNum) {
        return null;
    }
    
    @Override
    public SysUserRole deleteById(Integer id) {
        return null;
    }
}
