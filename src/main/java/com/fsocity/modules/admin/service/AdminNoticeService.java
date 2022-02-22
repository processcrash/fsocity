package com.fsocity.modules.admin.service;

import com.fsocity.modules.admin.entity.AdminNotice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * <p>
 * 通知公告表 服务类
 * </p>
 *
 * @author Zail
 * @since 2022-02-22
 */
public interface AdminNoticeService extends IService<AdminNotice> {
    
    /**
     * 分页查找
     */
    Page<AdminNotice> findAll(AdminNotice form, Integer pageNum, Integer pageSize);
    
    /**
     * 根据ID删除
     */
    boolean deleteById(Integer id);
}
