package com.fsocity.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysMenu;
import com.fsocity.modules.system.mapper.SysMenuMapper;
import com.fsocity.modules.system.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    
    @Override
    public Page<SysMenu> findAll(Integer pageSize, Integer pageNum) {
        return null;
    }
    
    @Override
    public SysMenu deleteById(Integer id) {
        return null;
    }
}
