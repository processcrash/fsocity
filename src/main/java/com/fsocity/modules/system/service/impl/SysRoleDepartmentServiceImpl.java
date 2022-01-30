package com.fsocity.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysRoleDepartment;
import com.fsocity.modules.system.mapper.SysRoleDepartmentMapper;
import com.fsocity.modules.system.service.SysRoleDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和部门关联表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Service
public class SysRoleDepartmentServiceImpl extends ServiceImpl<SysRoleDepartmentMapper, SysRoleDepartment> implements SysRoleDepartmentService {
    
    @Override
    public Page<SysRoleDepartment> findAll(Integer pageSize, Integer pageNum) {
        return null;
    }
    
    @Override
    public SysRoleDepartment deleteById(Integer id) {
        return null;
    }
}
