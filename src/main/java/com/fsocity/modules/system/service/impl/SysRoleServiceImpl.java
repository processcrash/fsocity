package com.fsocity.modules.system.service.impl;

import com.fsocity.modules.system.entity.SysRole;
import com.fsocity.modules.system.mapper.SysRoleMapper;
import com.fsocity.modules.system.service.SysRoleService;
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
 * @since 2022-02-18
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    
    @Autowired
    private SysRoleMapper sysRoleMapper;
    
    @Override
    public Page<SysRole> findAll(SysRole form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<SysRole> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(SysRole::getId, form.getId());
        }
        
        Page<SysRole> page = new Page<>(pageNum, pageSize);
        page = sysRoleMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        SysRole sysRole = new SysRole();
        sysRole.setId(id);
        // sysRole.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  sysRoleMapper.updateById(sysRole);
        return num == 1;
    }

}
