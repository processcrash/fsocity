package com.fsocity.modules.system.service.impl;

import com.fsocity.modules.system.entity.SysDepartment;
import com.fsocity.modules.system.mapper.SysDepartmentMapper;
import com.fsocity.modules.system.service.SysDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
@Service
public class SysDepartmentServiceImpl extends ServiceImpl<SysDepartmentMapper, SysDepartment> implements SysDepartmentService {
    
    @Autowired
    private SysDepartmentMapper sysDepartmentMapper;
    
    @Override
    public Page<SysDepartment> findAll(SysDepartment form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<SysDepartment> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(SysDepartment::getId, form.getId());
        }
        
        Page<SysDepartment> page = new Page<>(pageNum, pageSize);
        page = sysDepartmentMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        SysDepartment sysDepartment = new SysDepartment();
        sysDepartment.setId(id);
        // sysDepartment.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  sysDepartmentMapper.updateById(sysDepartment);
        return num == 1;
    }

}
