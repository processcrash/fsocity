package com.fsocity.modules.admin.service;

import com.fsocity.modules.admin.entity.AdminDictionaryData;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 字典数据表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-03-02
 */
public interface AdminDictionaryDataService extends IService<AdminDictionaryData> {
    
    /**
     * 分页查找
     */
    Page<AdminDictionaryData> findAll(AdminDictionaryData form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
