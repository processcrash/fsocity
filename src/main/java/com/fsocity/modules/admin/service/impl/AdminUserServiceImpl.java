package com.fsocity.modules.admin.service.impl;

import com.fsocity.modules.admin.entity.AdminUser;
import com.fsocity.modules.admin.mapper.AdminUserMapper;
import com.fsocity.modules.admin.service.AdminUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-02-24
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {
    
    @Autowired
    private AdminUserMapper adminUserMapper;
    
    @Override
    public Page<AdminUser> findAll(AdminUser form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<AdminUser> queryWrapper = new LambdaQueryWrapper<>();
                if (form.getId() != null) {
            queryWrapper.eq(AdminUser::getId, form.getId());
        }
        if (form.getDepartmentId() != null) {
            queryWrapper.eq(AdminUser::getDepartmentId, form.getDepartmentId());
        }
        if (form.getType() != null) {
            queryWrapper.eq(AdminUser::getType, form.getType());
        }
        if (form.getUsername() != null) {
            queryWrapper.eq(AdminUser::getUsername, form.getUsername());
        }
        if (form.getRealname() != null) {
            queryWrapper.eq(AdminUser::getRealname, form.getRealname());
        }
        if (form.getEmail() != null) {
            queryWrapper.eq(AdminUser::getEmail, form.getEmail());
        }
        if (form.getPhone() != null) {
            queryWrapper.eq(AdminUser::getPhone, form.getPhone());
        }
        if (form.getSex() != null) {
            queryWrapper.eq(AdminUser::getSex, form.getSex());
        }
        if (form.getAvatar() != null) {
            queryWrapper.eq(AdminUser::getAvatar, form.getAvatar());
        }
        if (form.getPassword() != null) {
            queryWrapper.eq(AdminUser::getPassword, form.getPassword());
        }
        if (form.getSalt() != null) {
            queryWrapper.eq(AdminUser::getSalt, form.getSalt());
        }
        if (form.getDelFlag() != null) {
            queryWrapper.eq(AdminUser::getDelFlag, form.getDelFlag());
        }
        if (form.getLoginIp() != null) {
            queryWrapper.eq(AdminUser::getLoginIp, form.getLoginIp());
        }
        if (form.getLoginDate() != null) {
            queryWrapper.eq(AdminUser::getLoginDate, form.getLoginDate());
        }
        if (form.getPwdUpdateDate() != null) {
            queryWrapper.eq(AdminUser::getPwdUpdateDate, form.getPwdUpdateDate());
        }
        if (form.getRemark() != null) {
            queryWrapper.eq(AdminUser::getRemark, form.getRemark());
        }
        if (form.getStatus() != null) {
            queryWrapper.eq(AdminUser::getStatus, form.getStatus());
        }
        if (form.getCreateBy() != null) {
            queryWrapper.eq(AdminUser::getCreateBy, form.getCreateBy());
        }
        if (form.getCreateTime() != null) {
            queryWrapper.eq(AdminUser::getCreateTime, form.getCreateTime());
        }
        if (form.getUpdateBy() != null) {
            queryWrapper.eq(AdminUser::getUpdateBy, form.getUpdateBy());
        }
        if (form.getUpdateTime() != null) {
            queryWrapper.eq(AdminUser::getUpdateTime, form.getUpdateTime());
        }
                
        Page<AdminUser> page = new Page<>(pageNum, pageSize);
        page = adminUserMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminUser adminUser = new AdminUser();
        adminUser.setId(id);
        // adminUser.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  adminUserMapper.updateById(adminUser);
        return num == 1;
    }

}
