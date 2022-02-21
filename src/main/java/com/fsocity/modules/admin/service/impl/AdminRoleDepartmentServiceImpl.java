package com.fsocity.modules.admin.service.impl;

import com.fsocity.modules.admin.entity.AdminRoleDepartment;
import com.fsocity.modules.admin.mapper.AdminRoleDepartmentMapper;
import com.fsocity.modules.admin.service.AdminRoleDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 角色和部门关联表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-02-21
 */
@Service
public class AdminRoleDepartmentServiceImpl extends ServiceImpl<AdminRoleDepartmentMapper, AdminRoleDepartment> implements AdminRoleDepartmentService {
    
    @Autowired
    private AdminRoleDepartmentMapper adminRoleDepartmentMapper;
    
    @Override
    public Page<AdminRoleDepartment> findAll(AdminRoleDepartment form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<AdminRoleDepartment> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(AdminRoleDepartment::getId, form.getId());
        }
        
        Page<AdminRoleDepartment> page = new Page<>(pageNum, pageSize);
        page = adminRoleDepartmentMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminRoleDepartment adminRoleDepartment = new AdminRoleDepartment();
        adminRoleDepartment.setId(id);
        // adminRoleDepartment.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  adminRoleDepartmentMapper.updateById(adminRoleDepartment);
        return num == 1;
    }

}
