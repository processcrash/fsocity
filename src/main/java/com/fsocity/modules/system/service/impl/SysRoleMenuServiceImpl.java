package com.fsocity.modules.system.service.impl;

import com.fsocity.modules.system.entity.SysRoleMenu;
import com.fsocity.modules.system.mapper.SysRoleMenuMapper;
import com.fsocity.modules.system.service.SysRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 角色和菜单关联表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {
    
    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;
    
    @Override
    public Page<SysRoleMenu> findAll(SysRoleMenu form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<SysRoleMenu> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(SysRoleMenu::getId, form.getId());
        }
        
        Page<SysRoleMenu> page = new Page<>(pageNum, pageSize);
        page = sysRoleMenuMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        SysRoleMenu sysRoleMenu = new SysRoleMenu();
        sysRoleMenu.setId(id);
        // sysRoleMenu.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  sysRoleMenuMapper.updateById(sysRoleMenu);
        return num == 1;
    }

}
