package com.fsocity.modules.admin.service.impl;

import com.fsocity.modules.admin.entity.AdminDepartment;
import com.fsocity.modules.admin.mapper.AdminDepartmentMapper;
import com.fsocity.modules.admin.service.AdminDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-07-07
 */
@Service
public class AdminDepartmentServiceImpl extends ServiceImpl<AdminDepartmentMapper, AdminDepartment> implements AdminDepartmentService {
    
    @Autowired
    private AdminDepartmentMapper adminDepartmentMapper;
    
    @Override
    public Page<AdminDepartment> findAll(AdminDepartment form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<AdminDepartment> queryWrapper = new LambdaQueryWrapper<>();
                if (form.getId() != null) {
            queryWrapper.eq(AdminDepartment::getId, form.getId());
        }
        if (form.getParentId() != null) {
            queryWrapper.eq(AdminDepartment::getParentId, form.getParentId());
        }
        if (form.getName() != null) {
            queryWrapper.eq(AdminDepartment::getName, form.getName());
        }
        if (form.getOrderNum() != null) {
            queryWrapper.eq(AdminDepartment::getOrderNum, form.getOrderNum());
        }
        if (form.getLeader() != null) {
            queryWrapper.eq(AdminDepartment::getLeader, form.getLeader());
        }
        if (form.getPhone() != null) {
            queryWrapper.eq(AdminDepartment::getPhone, form.getPhone());
        }
        if (form.getEmail() != null) {
            queryWrapper.eq(AdminDepartment::getEmail, form.getEmail());
        }
        if (form.getStatus() != null) {
            queryWrapper.eq(AdminDepartment::getStatus, form.getStatus());
        }
        if (form.getCreateBy() != null) {
            queryWrapper.eq(AdminDepartment::getCreateBy, form.getCreateBy());
        }
        if (form.getCreateTime() != null) {
            queryWrapper.eq(AdminDepartment::getCreateTime, form.getCreateTime());
        }
        if (form.getUpdateBy() != null) {
            queryWrapper.eq(AdminDepartment::getUpdateBy, form.getUpdateBy());
        }
        if (form.getUpdateTime() != null) {
            queryWrapper.eq(AdminDepartment::getUpdateTime, form.getUpdateTime());
        }
                
        Page<AdminDepartment> page = new Page<>(pageNum, pageSize);
        return this.page(page, queryWrapper);
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminDepartment adminDepartment = new AdminDepartment();
        adminDepartment.setId(id);
        // adminDepartment.setStatus(DeleteStatusEnum.DELETED.getCode());
        return this.updateById(adminDepartment);
    }

}
