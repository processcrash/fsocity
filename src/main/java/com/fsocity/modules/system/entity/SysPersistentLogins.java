package com.fsocity.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 登录持久化表
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_persistent_logins")
@ApiModel(value="SysPersistentLogins对象", description="登录持久化表")
public class SysPersistentLogins implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;

    private String series;

    private String token;

    private Date lastUsed;


}
