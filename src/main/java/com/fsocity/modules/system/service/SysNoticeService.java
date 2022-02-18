package com.fsocity.modules.system.service;

import com.fsocity.modules.system.entity.SysNotice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 通知公告表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-18
 */
public interface SysNoticeService extends IService<SysNotice> {
    
    /**
     * 分页查找
     */
    Page<SysNotice> findAll(SysNotice form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
