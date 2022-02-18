package com.fsocity.modules.system.service.impl;

import com.fsocity.modules.system.entity.SysMenu;
import com.fsocity.modules.system.mapper.SysMenuMapper;
import com.fsocity.modules.system.service.SysMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    
    @Autowired
    private SysMenuMapper sysMenuMapper;
    
    @Override
    public Page<SysMenu> findAll(SysMenu form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<SysMenu> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(SysMenu::getId, form.getId());
        }
        
        Page<SysMenu> page = new Page<>(pageNum, pageSize);
        page = sysMenuMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        SysMenu sysMenu = new SysMenu();
        sysMenu.setId(id);
        // sysMenu.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  sysMenuMapper.updateById(sysMenu);
        return num == 1;
    }

}
