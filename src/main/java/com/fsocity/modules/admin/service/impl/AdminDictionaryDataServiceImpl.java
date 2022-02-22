package com.fsocity.modules.admin.service.impl;

import com.fsocity.modules.admin.entity.AdminDictionaryData;
import com.fsocity.modules.admin.mapper.AdminDictionaryDataMapper;
import com.fsocity.modules.admin.service.AdminDictionaryDataService;
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
 * @since 2022-02-22
 */
@Service
public class AdminDictionaryDataServiceImpl extends ServiceImpl<AdminDictionaryDataMapper, AdminDictionaryData> implements AdminDictionaryDataService {
    
    @Autowired
    private AdminDictionaryDataMapper adminDictionaryDataMapper;
    
    @Override
    public Page<AdminDictionaryData> findAll(AdminDictionaryData form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<AdminDictionaryData> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(AdminDictionaryData::getId, form.getId());
        }
        
        Page<AdminDictionaryData> page = new Page<>(pageNum, pageSize);
        page = adminDictionaryDataMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminDictionaryData adminDictionaryData = new AdminDictionaryData();
        adminDictionaryData.setId(id);
        // adminDictionaryData.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  adminDictionaryDataMapper.updateById(adminDictionaryData);
        return num == 1;
    }

}
