package com.fsocity.modules.admin.service.impl;

import com.fsocity.modules.admin.entity.AdminDictionaryType;
import com.fsocity.modules.admin.mapper.AdminDictionaryTypeMapper;
import com.fsocity.modules.admin.service.AdminDictionaryTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 字典类型表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-07-07
 */
@Service
public class AdminDictionaryTypeServiceImpl extends ServiceImpl<AdminDictionaryTypeMapper, AdminDictionaryType> implements AdminDictionaryTypeService {
    
    @Autowired
    private AdminDictionaryTypeMapper adminDictionaryTypeMapper;
    
    @Override
    public Page<AdminDictionaryType> findAll(AdminDictionaryType form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<AdminDictionaryType> queryWrapper = new LambdaQueryWrapper<>();
                if (form.getId() != null) {
            queryWrapper.eq(AdminDictionaryType::getId, form.getId());
        }
        if (form.getCode() != null) {
            queryWrapper.eq(AdminDictionaryType::getCode, form.getCode());
        }
        if (form.getName() != null) {
            queryWrapper.eq(AdminDictionaryType::getName, form.getName());
        }
        if (form.getRemark() != null) {
            queryWrapper.eq(AdminDictionaryType::getRemark, form.getRemark());
        }
        if (form.getStatus() != null) {
            queryWrapper.eq(AdminDictionaryType::getStatus, form.getStatus());
        }
        if (form.getCreateBy() != null) {
            queryWrapper.eq(AdminDictionaryType::getCreateBy, form.getCreateBy());
        }
        if (form.getCreateTime() != null) {
            queryWrapper.eq(AdminDictionaryType::getCreateTime, form.getCreateTime());
        }
        if (form.getUpdateBy() != null) {
            queryWrapper.eq(AdminDictionaryType::getUpdateBy, form.getUpdateBy());
        }
        if (form.getUpdateTime() != null) {
            queryWrapper.eq(AdminDictionaryType::getUpdateTime, form.getUpdateTime());
        }
                
        Page<AdminDictionaryType> page = new Page<>(pageNum, pageSize);
        return this.page(page, queryWrapper);
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminDictionaryType adminDictionaryType = new AdminDictionaryType();
        adminDictionaryType.setId(id);
        // adminDictionaryType.setStatus(DeleteStatusEnum.DELETED.getCode());
        return this.updateById(adminDictionaryType);
    }

}
