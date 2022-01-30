package com.fsocity.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysDictionaryType;
import com.fsocity.modules.system.mapper.SysDictionaryTypeMapper;
import com.fsocity.modules.system.service.SysDictionaryTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Service
public class SysDictionaryTypeServiceImpl extends ServiceImpl<SysDictionaryTypeMapper, SysDictionaryType> implements SysDictionaryTypeService {
    
    @Override
    public Page<SysDictionaryType> findAll(Integer pageSize, Integer pageNum) {
        return null;
    }
    
    @Override
    public SysDictionaryType deleteById(Integer id) {
        return null;
    }
}
