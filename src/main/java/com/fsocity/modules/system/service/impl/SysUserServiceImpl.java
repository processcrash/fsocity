package com.fsocity.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysUser;
import com.fsocity.modules.system.mapper.SysUserMapper;
import com.fsocity.modules.system.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    
    @Override
    public Page<SysUser> findAll(Integer pageSize, Integer pageNum) {
        return null;
    }
    
    @Override
    public SysUser deleteById(Integer id) {
        return null;
    }
}
