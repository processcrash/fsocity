package com.fsocity.modules.admin.service.impl;

import com.fsocity.modules.admin.entity.AdminRoleMenu;
import com.fsocity.modules.admin.mapper.AdminRoleMenuMapper;
import com.fsocity.modules.admin.service.AdminRoleMenuService;
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
 * @since 2022-03-02
 */
@Service
public class AdminRoleMenuServiceImpl extends ServiceImpl<AdminRoleMenuMapper, AdminRoleMenu> implements AdminRoleMenuService {
    
    @Autowired
    private AdminRoleMenuMapper adminRoleMenuMapper;
    
    @Override
    public Page<AdminRoleMenu> findAll(AdminRoleMenu form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<AdminRoleMenu> queryWrapper = new LambdaQueryWrapper<>();
                if (form.getId() != null) {
            queryWrapper.eq(AdminRoleMenu::getId, form.getId());
        }
        if (form.getRoleId() != null) {
            queryWrapper.eq(AdminRoleMenu::getRoleId, form.getRoleId());
        }
        if (form.getMenuId() != null) {
            queryWrapper.eq(AdminRoleMenu::getMenuId, form.getMenuId());
        }
                
        Page<AdminRoleMenu> page = new Page<>(pageNum, pageSize);
        return this.page(page, queryWrapper);
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminRoleMenu adminRoleMenu = new AdminRoleMenu();
        adminRoleMenu.setId(id);
        // adminRoleMenu.setStatus(DeleteStatusEnum.DELETED.getCode());
        return this.updateById(adminRoleMenu);
    }

}
