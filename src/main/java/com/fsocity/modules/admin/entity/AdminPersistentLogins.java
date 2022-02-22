package com.fsocity.modules.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * <p>
 * 登录持久化表
 * </p>
 *
 * @author Zail
 * @since 2022-02-22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_admin_persistent_logins")
@ApiModel(value = "AdminPersistentLogins对象", description = "登录持久化表")
public class AdminPersistentLogins implements Serializable {

    private static final long serialVersionUID = 1L;

    private String series;

    private String username;

    private String token;

    private LocalDateTime lastUsed;


}
