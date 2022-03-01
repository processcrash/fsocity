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
 * 字典类型表
 * </p>
 *
 * @author Zail
 * @since 2022-03-02
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_admin_dictionary_type")
@ApiModel(value = "AdminDictionaryType对象", description = "字典类型表")
public class AdminDictionaryType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("字典类型ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("字典代码")
    private String code;

    @ApiModelProperty("字典名称")
    private String name;

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
