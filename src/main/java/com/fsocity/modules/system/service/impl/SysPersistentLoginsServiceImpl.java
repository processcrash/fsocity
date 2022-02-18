package com.fsocity.modules.system.service.impl;

import com.fsocity.modules.system.entity.SysPersistentLogins;
import com.fsocity.modules.system.mapper.SysPersistentLoginsMapper;
import com.fsocity.modules.system.service.SysPersistentLoginsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 登录持久化表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
@Service
public class SysPersistentLoginsServiceImpl extends ServiceImpl<SysPersistentLoginsMapper, SysPersistentLogins> implements SysPersistentLoginsService {
    
    @Autowired
    private SysPersistentLoginsMapper sysPersistentLoginsMapper;
    
    @Override
    public Page<SysPersistentLogins> findAll(SysPersistentLogins form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<SysPersistentLogins> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(SysPersistentLogins::getId, form.getId());
        }
        
        Page<SysPersistentLogins> page = new Page<>(pageNum, pageSize);
        page = sysPersistentLoginsMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        SysPersistentLogins sysPersistentLogins = new SysPersistentLogins();
        sysPersistentLogins.setId(id);
        // sysPersistentLogins.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  sysPersistentLoginsMapper.updateById(sysPersistentLogins);
        return num == 1;
    }

}
