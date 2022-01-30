package com.fsocity.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysDictionaryData;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 字典数据表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
public interface SysDictionaryDataService extends IService<SysDictionaryData> {
    
    Page<SysDictionaryData> findAll(Integer pageSize, Integer pageNum);
    
    SysDictionaryData deleteById(Integer id);
    
}
