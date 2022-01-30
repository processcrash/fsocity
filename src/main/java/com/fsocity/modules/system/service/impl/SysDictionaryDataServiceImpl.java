package com.fsocity.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysDictionaryData;
import com.fsocity.modules.system.mapper.SysDictionaryDataMapper;
import com.fsocity.modules.system.service.SysDictionaryDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 字典数据表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Service
public class SysDictionaryDataServiceImpl extends ServiceImpl<SysDictionaryDataMapper, SysDictionaryData> implements SysDictionaryDataService {
    
    @Override
    public Page<SysDictionaryData> findAll(Integer pageSize, Integer pageNum) {
        return null;
    }
    
    @Override
    public SysDictionaryData deleteById(Integer id) {
        return null;
    }
}
