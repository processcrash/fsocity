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
 * 定时任务调度表
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_job")
@ApiModel(value="SysJob对象", description="定时任务调度表")
public class SysJob implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "任务ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "任务组名")
    private String group;

    @ApiModelProperty(value = "任务名称")
    private String name;

    @ApiModelProperty(value = "调用目标字符串")
    private String invokeTarget;

    @ApiModelProperty(value = "cron执行表达式")
    private String cronExpression;

    @ApiModelProperty(value = "计划执行错误策略（0：放弃执行；1：立即执行；2：执行一次；）")
    private Integer misfirePolicy;

    @ApiModelProperty(value = "是否并发执行（0：禁止；1：允许）")
    private Integer concurrent;

    @ApiModelProperty(value = "备注信息")
    private String remark;

    @ApiModelProperty(value = "状态（0：正常；1：暂停）")
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
