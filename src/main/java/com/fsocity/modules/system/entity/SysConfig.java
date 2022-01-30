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
 * 参数配置表
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_config")
@ApiModel(value="SysConfig对象", description="参数配置表")
public class SysConfig implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "参数主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "系统内置（0：是；1：否）")
    private Integer type;

    @ApiModelProperty(value = "参数名称")
    private String name;

    @ApiModelProperty(value = "参数键名")
    private String key;

    @ApiModelProperty(value = "参数键值")
    private String value;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "创建者")
    private Integer createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新者")
    private Integer updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;


}
