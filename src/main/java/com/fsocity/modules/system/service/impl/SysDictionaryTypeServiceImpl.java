package com.fsocity.modules.system.service.impl;

import com.fsocity.modules.system.entity.SysDictionaryType;
import com.fsocity.modules.system.mapper.SysDictionaryTypeMapper;
import com.fsocity.modules.system.service.SysDictionaryTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
@Service
public class SysDictionaryTypeServiceImpl extends ServiceImpl<SysDictionaryTypeMapper, SysDictionaryType> implements SysDictionaryTypeService {
    
    @Autowired
    private SysDictionaryTypeMapper sysDictionaryTypeMapper;
    
    @Override
    public Page<SysDictionaryType> findAll(SysDictionaryType form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<SysDictionaryType> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(SysDictionaryType::getId, form.getId());
        }
        
        Page<SysDictionaryType> page = new Page<>(pageNum, pageSize);
        page = sysDictionaryTypeMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        SysDictionaryType sysDictionaryType = new SysDictionaryType();
        sysDictionaryType.setId(id);
        // sysDictionaryType.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  sysDictionaryTypeMapper.updateById(sysDictionaryType);
        return num == 1;
    }

}
