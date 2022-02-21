package com.fsocity.modules.admin.service.impl;

import com.fsocity.modules.admin.entity.AdminUserRole;
import com.fsocity.modules.admin.mapper.AdminUserRoleMapper;
import com.fsocity.modules.admin.service.AdminUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-02-21
 */
@Service
public class AdminUserRoleServiceImpl extends ServiceImpl<AdminUserRoleMapper, AdminUserRole> implements AdminUserRoleService {
    
    @Autowired
    private AdminUserRoleMapper adminUserRoleMapper;
    
    @Override
    public Page<AdminUserRole> findAll(AdminUserRole form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<AdminUserRole> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(AdminUserRole::getId, form.getId());
        }
        
        Page<AdminUserRole> page = new Page<>(pageNum, pageSize);
        page = adminUserRoleMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminUserRole adminUserRole = new AdminUserRole();
        adminUserRole.setId(id);
        // adminUserRole.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  adminUserRoleMapper.updateById(adminUserRole);
        return num == 1;
    }

}
