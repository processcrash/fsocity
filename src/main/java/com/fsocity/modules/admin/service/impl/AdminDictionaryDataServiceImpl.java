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
 * @since 2022-07-07
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
        if (form.getCode() != null) {
            queryWrapper.eq(AdminDictionaryData::getCode, form.getCode());
        }
        if (form.getLabel() != null) {
            queryWrapper.eq(AdminDictionaryData::getLabel, form.getLabel());
        }
        if (form.getValue() != null) {
            queryWrapper.eq(AdminDictionaryData::getValue, form.getValue());
        }
        if (form.getSortNum() != null) {
            queryWrapper.eq(AdminDictionaryData::getSortNum, form.getSortNum());
        }
        if (form.getIsDefault() != null) {
            queryWrapper.eq(AdminDictionaryData::getIsDefault, form.getIsDefault());
        }
        if (form.getRemark() != null) {
            queryWrapper.eq(AdminDictionaryData::getRemark, form.getRemark());
        }
        if (form.getStatus() != null) {
            queryWrapper.eq(AdminDictionaryData::getStatus, form.getStatus());
        }
        if (form.getCreateBy() != null) {
            queryWrapper.eq(AdminDictionaryData::getCreateBy, form.getCreateBy());
        }
        if (form.getCreateTime() != null) {
            queryWrapper.eq(AdminDictionaryData::getCreateTime, form.getCreateTime());
        }
        if (form.getUpdateBy() != null) {
            queryWrapper.eq(AdminDictionaryData::getUpdateBy, form.getUpdateBy());
        }
        if (form.getUpdateTime() != null) {
            queryWrapper.eq(AdminDictionaryData::getUpdateTime, form.getUpdateTime());
        }
                
        Page<AdminDictionaryData> page = new Page<>(pageNum, pageSize);
        return this.page(page, queryWrapper);
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminDictionaryData adminDictionaryData = new AdminDictionaryData();
        adminDictionaryData.setId(id);
        // adminDictionaryData.setStatus(DeleteStatusEnum.DELETED.getCode());
        return this.updateById(adminDictionaryData);
    }

}
