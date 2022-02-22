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
 * @since 2022-02-22
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
        
        Page<AdminMenu> page = new Page<>(pageNum, pageSize);
        page = adminMenuMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminMenu adminMenu = new AdminMenu();
        adminMenu.setId(id);
        // adminMenu.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  adminMenuMapper.updateById(adminMenu);
        return num == 1;
    }

}
