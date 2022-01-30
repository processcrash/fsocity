package com.fsocity.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色信息表
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role")
@ApiModel(value="SysRole对象", description="角色信息表")
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "角色权限字符串")
    private String key;

    @ApiModelProperty(value = "角色名称")
    private String name;

    @ApiModelProperty(value = "显示顺序")
    private Integer sortNum;

    @ApiModelProperty(value = "数据范围（1：全部数据权限 2：自定数据权限 3：本部门数据权限 4：本部门及以下数据权限）")
    private Integer dataScope;

    @ApiModelProperty(value = "删除标志（0：存在；1：删除）")
    private Integer delFlag;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "角色状态（0：正常；1：停用）")
    private Integer status;

    @ApiModelProperty(value = "创建者ID")
    private Integer createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新者ID")
    private Integer updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;


}
