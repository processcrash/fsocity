package com.fsocity.modules.admin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * 菜单权限表
 * </p>
 *
 * @author Zail
 * @since 2022-03-02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_admin_menu")
@ApiModel(value = "AdminMenu对象", description = "菜单权限表")
public class AdminMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("菜单ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("父菜单ID")
    private Integer parentId;

    @ApiModelProperty("菜单类型（0：目录；1：菜单；2：按钮）")
    private Integer type;

    @ApiModelProperty("菜单名称")
    private String name;

    @ApiModelProperty("显示顺序")
    private Integer orderNum;

    @ApiModelProperty("请求地址")
    private String url;

    @ApiModelProperty("打开方式（0：默认打开；1：打开页标签；2：打开新窗口）")
    private Integer target;

    @ApiModelProperty("菜单状态（0：显示；1：隐藏）")
    private Integer visible;

    @ApiModelProperty("是否刷新（0：刷新；1：不刷新）")
    private Integer isRefresh;

    @ApiModelProperty("权限标识")
    private String perms;

    @ApiModelProperty("菜单图标")
    private String icon;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("状态（0：正常；1：删除）")
    private Integer status;

    @ApiModelProperty("创建者ID")
    private Integer createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新者ID")
    private Integer updateBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;


}
