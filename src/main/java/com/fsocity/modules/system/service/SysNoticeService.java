package com.fsocity.modules.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fsocity.modules.system.entity.SysNotice;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 通知公告表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
public interface SysNoticeService extends IService<SysNotice> {
    
    Page<SysNotice> findAll(Integer pageSize, Integer pageNum);
    
    SysNotice deleteById(Integer id);
    
}
