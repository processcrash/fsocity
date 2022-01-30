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
 * 字典数据表
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_dictionary_data")
@ApiModel(value="SysDictionaryData对象", description="字典数据表")
public class SysDictionaryData implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "字典编码")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "字典类型")
    private String code;

    @ApiModelProperty(value = "字典标签")
    private String label;

    @ApiModelProperty(value = "字典键值")
    private String value;

    @ApiModelProperty(value = "字典排序")
    private Integer sortNum;

    @ApiModelProperty(value = "是否默认（0：否；1：是）")
    private Integer isDefault;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "状态（0：正常；1：停用）")
    private Integer status;

    @ApiModelProperty(value = "创建者")
    private Integer createBy;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新者")
    private Integer updateBy;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;


}
