package com.fsocity.modules.system.service;

import com.fsocity.modules.system.entity.SysDictionaryData;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 字典数据表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
public interface SysDictionaryDataService extends IService<SysDictionaryData> {
    
    /**
     * 分页查找
     */
    Page<SysDictionaryData> findAll(SysDictionaryData form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
