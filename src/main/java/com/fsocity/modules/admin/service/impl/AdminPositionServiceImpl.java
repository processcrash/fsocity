package com.fsocity.modules.admin.service.impl;

import com.fsocity.modules.admin.entity.AdminPosition;
import com.fsocity.modules.admin.mapper.AdminPositionMapper;
import com.fsocity.modules.admin.service.AdminPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 岗位信息表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-02-21
 */
@Service
public class AdminPositionServiceImpl extends ServiceImpl<AdminPositionMapper, AdminPosition> implements AdminPositionService {
    
    @Autowired
    private AdminPositionMapper adminPositionMapper;
    
    @Override
    public Page<AdminPosition> findAll(AdminPosition form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<AdminPosition> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(AdminPosition::getId, form.getId());
        }
        
        Page<AdminPosition> page = new Page<>(pageNum, pageSize);
        page = adminPositionMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminPosition adminPosition = new AdminPosition();
        adminPosition.setId(id);
        // adminPosition.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  adminPositionMapper.updateById(adminPosition);
        return num == 1;
    }

}
