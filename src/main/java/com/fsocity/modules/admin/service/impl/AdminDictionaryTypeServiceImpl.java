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
 * @since 2022-02-21
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
        
        Page<AdminDictionaryType> page = new Page<>(pageNum, pageSize);
        page = adminDictionaryTypeMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        AdminDictionaryType adminDictionaryType = new AdminDictionaryType();
        adminDictionaryType.setId(id);
        // adminDictionaryType.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  adminDictionaryTypeMapper.updateById(adminDictionaryType);
        return num == 1;
    }

}
