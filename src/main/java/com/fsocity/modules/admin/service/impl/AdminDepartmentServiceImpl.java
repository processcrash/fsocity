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
 * @since 2022-02-22
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
        
        Page<AdminDepartment> page = new Page<>(pageNum, pageSize);
        page = adminDepartmentMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminDepartment adminDepartment = new AdminDepartment();
        adminDepartment.setId(id);
        // adminDepartment.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  adminDepartmentMapper.updateById(adminDepartment);
        return num == 1;
    }

}
