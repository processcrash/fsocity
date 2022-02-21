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
 * @since 2022-02-21
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
        
        Page<AdminRole> page = new Page<>(pageNum, pageSize);
        page = adminRoleMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminRole adminRole = new AdminRole();
        adminRole.setId(id);
        // adminRole.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  adminRoleMapper.updateById(adminRole);
        return num == 1;
    }

}
