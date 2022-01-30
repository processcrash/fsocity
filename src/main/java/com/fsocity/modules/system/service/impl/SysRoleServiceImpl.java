package com.fsocity.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysRole;
import com.fsocity.modules.system.mapper.SysRoleMapper;
import com.fsocity.modules.system.service.SysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    
    @Override
    public Page<SysRole> findAll(Integer pageSize, Integer pageNum) {
        return null;
    }
    
    @Override
    public SysRole deleteById(Integer id) {
        return null;
    }
}
