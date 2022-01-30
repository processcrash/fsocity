package com.fsocity.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysDictionaryType;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 字典类型表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
public interface SysDictionaryTypeService extends IService<SysDictionaryType> {
    
    Page<SysDictionaryType> findAll(Integer pageSize, Integer pageNum);
    
    SysDictionaryType deleteById(Integer id);
    
}
