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
 * 参数配置表
 * </p>
 *
 * @author Zail
 * @since 2022-02-22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_admin_config")
@ApiModel(value = "AdminConfig对象", description = "参数配置表")
public class AdminConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("配置ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("系统内置（0：是；1：否）")
    private Integer type;

    @ApiModelProperty("参数名称")
    private String name;

    @ApiModelProperty("参数键名")
    private String key;

    @ApiModelProperty("参数键值")
    private String value;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("状态（0：正常；1：删除）")
    private Integer status;

    @ApiModelProperty("创建者")
    private Integer createBy;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty("更新者")
    private Integer updateBy;

    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;


}
