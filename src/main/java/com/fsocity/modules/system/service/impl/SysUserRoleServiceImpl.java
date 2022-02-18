package com.fsocity.modules.system.service.impl;

import com.fsocity.modules.system.entity.SysUserRole;
import com.fsocity.modules.system.mapper.SysUserRoleMapper;
import com.fsocity.modules.system.service.SysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 用户和角色关联表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
@Service
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRole> implements SysUserRoleService {
    
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;
    
    @Override
    public Page<SysUserRole> findAll(SysUserRole form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<SysUserRole> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(SysUserRole::getId, form.getId());
        }
        
        Page<SysUserRole> page = new Page<>(pageNum, pageSize);
        page = sysUserRoleMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setId(id);
        // sysUserRole.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  sysUserRoleMapper.updateById(sysUserRole);
        return num == 1;
    }

}
