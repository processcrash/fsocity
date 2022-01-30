package com.fsocity.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysDepartment;
import com.fsocity.modules.system.mapper.SysDepartmentMapper;
import com.fsocity.modules.system.service.SysDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Service
public class SysDepartmentServiceImpl extends ServiceImpl<SysDepartmentMapper, SysDepartment> implements SysDepartmentService {
    
    @Override
    public Page<SysDepartment> findAll(Integer pageSize, Integer pageNum) {
        return null;
    }
    
    @Override
    public SysDepartment deleteById(Integer id) {
        return null;
    }
}
