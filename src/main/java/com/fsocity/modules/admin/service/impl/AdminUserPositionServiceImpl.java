package com.fsocity.modules.admin.service.impl;

import com.fsocity.modules.admin.entity.AdminUserPosition;
import com.fsocity.modules.admin.mapper.AdminUserPositionMapper;
import com.fsocity.modules.admin.service.AdminUserPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 用户与岗位关联表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-02-21
 */
@Service
public class AdminUserPositionServiceImpl extends ServiceImpl<AdminUserPositionMapper, AdminUserPosition> implements AdminUserPositionService {
    
    @Autowired
    private AdminUserPositionMapper adminUserPositionMapper;
    
    @Override
    public Page<AdminUserPosition> findAll(AdminUserPosition form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<AdminUserPosition> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(AdminUserPosition::getId, form.getId());
        }
        
        Page<AdminUserPosition> page = new Page<>(pageNum, pageSize);
        page = adminUserPositionMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminUserPosition adminUserPosition = new AdminUserPosition();
        adminUserPosition.setId(id);
        // adminUserPosition.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  adminUserPositionMapper.updateById(adminUserPosition);
        return num == 1;
    }

}
