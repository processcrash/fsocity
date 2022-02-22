package com.fsocity.modules.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
 * @since 2022-02-22
 */
@Service
public class AdminUserServiceImpl extends ServiceImpl<AdminUserMapper, AdminUser> implements AdminUserService {
    
    @Autowired
    private AdminUserMapper adminUserMapper;
    
    @Override
    public AdminUser getByUsername(String username) {
        QueryWrapper<AdminUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda()
                .eq(AdminUser::getUsername, username);
        return adminUserMapper.selectOne(queryWrapper);
    }
    
    @Override
    public Page<AdminUser> findAll(AdminUser form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<AdminUser> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(AdminUser::getId, form.getId());
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
