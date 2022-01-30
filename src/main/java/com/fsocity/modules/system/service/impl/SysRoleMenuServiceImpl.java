package com.fsocity.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysRoleMenu;
import com.fsocity.modules.system.mapper.SysRoleMenuMapper;
import com.fsocity.modules.system.service.SysRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {
    
    @Override
    public Page<SysRoleMenu> findAll(Integer pageSize, Integer pageNum) {
        return null;
    }
    
    @Override
    public SysRoleMenu deleteById(Integer id) {
        return null;
    }
}
