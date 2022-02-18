package com.fsocity.modules.system.service.impl;

import com.fsocity.modules.system.entity.SysUser;
import com.fsocity.modules.system.mapper.SysUserMapper;
import com.fsocity.modules.system.service.SysUserService;
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
 * @since 2022-02-18
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    
    @Autowired
    private SysUserMapper sysUserMapper;
    
    @Override
    public Page<SysUser> findAll(SysUser form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(SysUser::getId, form.getId());
        }
        
        Page<SysUser> page = new Page<>(pageNum, pageSize);
        page = sysUserMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        SysUser sysUser = new SysUser();
        sysUser.setId(id);
        // sysUser.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  sysUserMapper.updateById(sysUser);
        return num == 1;
    }

}
