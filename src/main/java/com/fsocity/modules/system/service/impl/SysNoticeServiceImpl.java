package com.fsocity.modules.system.service.impl;

import com.fsocity.modules.system.entity.SysNotice;
import com.fsocity.modules.system.mapper.SysNoticeMapper;
import com.fsocity.modules.system.service.SysNoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * <p>
 * 通知公告表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
@Service
public class SysNoticeServiceImpl extends ServiceImpl<SysNoticeMapper, SysNotice> implements SysNoticeService {
    
    @Autowired
    private SysNoticeMapper sysNoticeMapper;
    
    @Override
    public Page<SysNotice> findAll(SysNotice form, Integer pageNum, Integer pageSize) {
        LambdaQueryWrapper<SysNotice> queryWrapper = new LambdaQueryWrapper<>();
        if (form.getId() != null) {
            queryWrapper.eq(SysNotice::getId, form.getId());
        }
        
        Page<SysNotice> page = new Page<>(pageNum, pageSize);
        page = sysNoticeMapper.selectPage(page, queryWrapper);
        return page;
    }
    
    @Override
    public boolean deleteById(Integer id) {
        SysNotice sysNotice = new SysNotice();
        sysNotice.setId(id);
        // sysNotice.setStatus(DeleteStatusEnum.DELETED.getCode());
        int num =  sysNoticeMapper.updateById(sysNotice);
        return num == 1;
    }

}
