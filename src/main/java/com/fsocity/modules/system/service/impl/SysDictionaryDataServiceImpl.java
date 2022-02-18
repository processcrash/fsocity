package com.fsocity.modules.system.service.impl;

import com.fsocity.modules.system.entity.SysDictionaryData;
import com.fsocity.modules.system.mapper.SysDictionaryDataMapper;
import com.fsocity.modules.system.service.SysDictionaryDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 字典数据表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
@Service
public class SysDictionaryDataServiceImpl extends ServiceImpl<SysDictionaryDataMapper, SysDictionaryData> implements SysDictionaryDataService {
    
    @Autowired
    private SysDictionaryDataMapper sysDictionaryDataMapper;
    
    @Override
    public Page<SysDictionaryData> findAll(SysDictionaryData form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<SysDictionaryData> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(SysDictionaryData::getId, form.getId());
        }
        
        Page<SysDictionaryData> page = new Page<>(pageNum, pageSize);
        page = sysDictionaryDataMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        SysDictionaryData sysDictionaryData = new SysDictionaryData();
        sysDictionaryData.setId(id);
        // sysDictionaryData.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  sysDictionaryDataMapper.updateById(sysDictionaryData);
        return num == 1;
    }

}
