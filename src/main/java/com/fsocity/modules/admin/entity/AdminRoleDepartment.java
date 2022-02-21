package com.fsocity.modules.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

/**
 * <p>
 * 角色和部门关联表
 * </p>
 *
 * @author Zail
 * @since 2022-02-21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_admin_role_department")
@ApiModel(value = "AdminRoleDepartment对象", description = "角色和部门关联表")
public class AdminRoleDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("角色ID")
    private Integer roleId;

    @ApiModelProperty("部门ID")
    private Integer departmentId;


}
