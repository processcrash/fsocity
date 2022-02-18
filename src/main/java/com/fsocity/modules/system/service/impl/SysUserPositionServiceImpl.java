package com.fsocity.modules.system.service.impl;

import com.fsocity.modules.system.entity.SysUserPosition;
import com.fsocity.modules.system.mapper.SysUserPositionMapper;
import com.fsocity.modules.system.service.SysUserPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 用户与岗位关联表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
@Service
public class SysUserPositionServiceImpl extends ServiceImpl<SysUserPositionMapper, SysUserPosition> implements SysUserPositionService {
    
    @Autowired
    private SysUserPositionMapper sysUserPositionMapper;
    
    @Override
    public Page<SysUserPosition> findAll(SysUserPosition form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<SysUserPosition> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(SysUserPosition::getId, form.getId());
        }
        
        Page<SysUserPosition> page = new Page<>(pageNum, pageSize);
        page = sysUserPositionMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        SysUserPosition sysUserPosition = new SysUserPosition();
        sysUserPosition.setId(id);
        // sysUserPosition.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  sysUserPositionMapper.updateById(sysUserPosition);
        return num == 1;
    }

}
