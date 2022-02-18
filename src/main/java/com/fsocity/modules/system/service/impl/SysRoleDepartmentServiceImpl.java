package com.fsocity.modules.system.service.impl;

import com.fsocity.modules.system.entity.SysRoleDepartment;
import com.fsocity.modules.system.mapper.SysRoleDepartmentMapper;
import com.fsocity.modules.system.service.SysRoleDepartmentService;
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
 * @since 2022-02-18
 */
@Service
public class SysRoleDepartmentServiceImpl extends ServiceImpl<SysRoleDepartmentMapper, SysRoleDepartment> implements SysRoleDepartmentService {
    
    @Autowired
    private SysRoleDepartmentMapper sysRoleDepartmentMapper;
    
    @Override
    public Page<SysRoleDepartment> findAll(SysRoleDepartment form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<SysRoleDepartment> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(SysRoleDepartment::getId, form.getId());
        }
        
        Page<SysRoleDepartment> page = new Page<>(pageNum, pageSize);
        page = sysRoleDepartmentMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        SysRoleDepartment sysRoleDepartment = new SysRoleDepartment();
        sysRoleDepartment.setId(id);
        // sysRoleDepartment.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  sysRoleDepartmentMapper.updateById(sysRoleDepartment);
        return num == 1;
    }

}
