package com.fsocity.modules.admin.service.impl;

import com.fsocity.modules.admin.entity.AdminMenu;
import com.fsocity.modules.admin.mapper.AdminMenuMapper;
import com.fsocity.modules.admin.service.AdminMenuService;
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
 * @since 2022-03-02
 */
@Service
public class AdminMenuServiceImpl extends ServiceImpl<AdminMenuMapper, AdminMenu> implements AdminMenuService {
    
    @Autowired
    private AdminMenuMapper adminMenuMapper;
    
    @Override
    public Page<AdminMenu> findAll(AdminMenu form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<AdminMenu> queryWrapper = new LambdaQueryWrapper<>();
                if (form.getId() != null) {
            queryWrapper.eq(AdminMenu::getId, form.getId());
        }
        if (form.getParentId() != null) {
            queryWrapper.eq(AdminMenu::getParentId, form.getParentId());
        }
        if (form.getType() != null) {
            queryWrapper.eq(AdminMenu::getType, form.getType());
        }
        if (form.getName() != null) {
            queryWrapper.eq(AdminMenu::getName, form.getName());
        }
        if (form.getOrderNum() != null) {
            queryWrapper.eq(AdminMenu::getOrderNum, form.getOrderNum());
        }
        if (form.getUrl() != null) {
            queryWrapper.eq(AdminMenu::getUrl, form.getUrl());
        }
        if (form.getTarget() != null) {
            queryWrapper.eq(AdminMenu::getTarget, form.getTarget());
        }
        if (form.getVisible() != null) {
            queryWrapper.eq(AdminMenu::getVisible, form.getVisible());
        }
        if (form.getIsRefresh() != null) {
            queryWrapper.eq(AdminMenu::getIsRefresh, form.getIsRefresh());
        }
        if (form.getPerms() != null) {
            queryWrapper.eq(AdminMenu::getPerms, form.getPerms());
        }
        if (form.getIcon() != null) {
            queryWrapper.eq(AdminMenu::getIcon, form.getIcon());
        }
        if (form.getRemark() != null) {
            queryWrapper.eq(AdminMenu::getRemark, form.getRemark());
        }
        if (form.getStatus() != null) {
            queryWrapper.eq(AdminMenu::getStatus, form.getStatus());
        }
        if (form.getCreateBy() != null) {
            queryWrapper.eq(AdminMenu::getCreateBy, form.getCreateBy());
        }
        if (form.getCreateTime() != null) {
            queryWrapper.eq(AdminMenu::getCreateTime, form.getCreateTime());
        }
        if (form.getUpdateBy() != null) {
            queryWrapper.eq(AdminMenu::getUpdateBy, form.getUpdateBy());
        }
        if (form.getUpdateTime() != null) {
            queryWrapper.eq(AdminMenu::getUpdateTime, form.getUpdateTime());
        }
                
        Page<AdminMenu> page = new Page<>(pageNum, pageSize);
        return this.page(page, queryWrapper);
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminMenu adminMenu = new AdminMenu();
        adminMenu.setId(id);
        // adminMenu.setStatus(DeleteStatusEnum.DELETED.getCode());
        return this.updateById(adminMenu);
    }

}
