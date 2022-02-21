package com.fsocity.modules.admin.service;

import com.fsocity.modules.admin.entity.AdminDictionaryType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 字典类型表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-21
 */
public interface AdminDictionaryTypeService extends IService<AdminDictionaryType> {
    
    /**
     * 分页查找
     */
    Page<AdminDictionaryType> findAll(AdminDictionaryType form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
