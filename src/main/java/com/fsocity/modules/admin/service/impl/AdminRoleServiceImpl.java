package com.fsocity.modules.admin.service.impl;

import com.fsocity.modules.admin.entity.AdminRole;
import com.fsocity.modules.admin.mapper.AdminRoleMapper;
import com.fsocity.modules.admin.service.AdminRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 角色信息表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-03-02
 */
@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements AdminRoleService {
    
    @Autowired
    private AdminRoleMapper adminRoleMapper;
    
    @Override
    public Page<AdminRole> findAll(AdminRole form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<AdminRole> queryWrapper = new LambdaQueryWrapper<>();
                if (form.getId() != null) {
            queryWrapper.eq(AdminRole::getId, form.getId());
        }
        if (form.getKey() != null) {
            queryWrapper.eq(AdminRole::getKey, form.getKey());
        }
        if (form.getName() != null) {
            queryWrapper.eq(AdminRole::getName, form.getName());
        }
        if (form.getSortNum() != null) {
            queryWrapper.eq(AdminRole::getSortNum, form.getSortNum());
        }
        if (form.getDataScope() != null) {
            queryWrapper.eq(AdminRole::getDataScope, form.getDataScope());
        }
        if (form.getRemark() != null) {
            queryWrapper.eq(AdminRole::getRemark, form.getRemark());
        }
        if (form.getStatus() != null) {
            queryWrapper.eq(AdminRole::getStatus, form.getStatus());
        }
        if (form.getCreateBy() != null) {
            queryWrapper.eq(AdminRole::getCreateBy, form.getCreateBy());
        }
        if (form.getCreateTime() != null) {
            queryWrapper.eq(AdminRole::getCreateTime, form.getCreateTime());
        }
        if (form.getUpdateBy() != null) {
            queryWrapper.eq(AdminRole::getUpdateBy, form.getUpdateBy());
        }
        if (form.getUpdateTime() != null) {
            queryWrapper.eq(AdminRole::getUpdateTime, form.getUpdateTime());
        }
                
        Page<AdminRole> page = new Page<>(pageNum, pageSize);
        return this.page(page, queryWrapper);
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminRole adminRole = new AdminRole();
        adminRole.setId(id);
        // adminRole.setStatus(DeleteStatusEnum.DELETED.getCode());
        return this.updateById(adminRole);
    }

}
