package com.fsocity.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysPosition;
import com.fsocity.modules.system.mapper.SysPositionMapper;
import com.fsocity.modules.system.service.SysPositionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位信息表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Service
public class SysPositionServiceImpl extends ServiceImpl<SysPositionMapper, SysPosition> implements SysPositionService {
    
    @Override
    public Page<SysPosition> findAll(Integer pageSize, Integer pageNum) {
        return null;
    }
    
    @Override
    public SysPosition deleteById(Integer id) {
        return null;
    }
}
