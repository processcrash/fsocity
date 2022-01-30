package com.fsocity.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysNotice;
import com.fsocity.modules.system.mapper.SysNoticeMapper;
import com.fsocity.modules.system.service.SysNoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 通知公告表 服务实现类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Service
public class SysNoticeServiceImpl extends ServiceImpl<SysNoticeMapper, SysNotice> implements SysNoticeService {
    
    @Override
    public Page<SysNotice> findAll(Integer pageSize, Integer pageNum) {
        return null;
    }
    
    @Override
    public SysNotice deleteById(Integer id) {
        return null;
    }
}
