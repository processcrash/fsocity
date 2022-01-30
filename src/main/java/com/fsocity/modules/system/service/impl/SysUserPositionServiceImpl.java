package com.fsocity.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysUserPosition;
import com.fsocity.modules.system.mapper.SysUserPositionMapper;
import com.fsocity.modules.system.service.SysUserPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与岗位关联表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Service
public class SysUserPositionServiceImpl extends ServiceImpl<SysUserPositionMapper, SysUserPosition> implements SysUserPositionService {
    
    @Override
    public Page<SysUserPosition> findAll(Integer pageSize, Integer pageNum) {
        return null;
    }
    
    @Override
    public SysUserPosition deleteById(Integer id) {
        return null;
    }
}
