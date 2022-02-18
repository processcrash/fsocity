package com.fsocity.modules.system.service;

import com.fsocity.modules.system.entity.SysDictionaryType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 字典类型表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
public interface SysDictionaryTypeService extends IService<SysDictionaryType> {
    
    /**
     * 分页查找
     */
    Page<SysDictionaryType> findAll(SysDictionaryType form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
