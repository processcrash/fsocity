package com.fsocity.modules.system.service.impl;

import com.fsocity.modules.system.entity.SysPosition;
import com.fsocity.modules.system.mapper.SysPositionMapper;
import com.fsocity.modules.system.service.SysPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 岗位信息表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
@Service
public class SysPositionServiceImpl extends ServiceImpl<SysPositionMapper, SysPosition> implements SysPositionService {
    
    @Autowired
    private SysPositionMapper sysPositionMapper;
    
    @Override
    public Page<SysPosition> findAll(SysPosition form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<SysPosition> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(SysPosition::getId, form.getId());
        }
        
        Page<SysPosition> page = new Page<>(pageNum, pageSize);
        page = sysPositionMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        SysPosition sysPosition = new SysPosition();
        sysPosition.setId(id);
        // sysPosition.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  sysPositionMapper.updateById(sysPosition);
        return num == 1;
    }

}
