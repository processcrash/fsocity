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
 * 定时任务调度表
 * </p>
 *
 * @author Zail
 * @since 2022-02-21
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_admin_job")
@ApiModel(value = "AdminJob对象", description = "定时任务调度表")
public class AdminJob implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("任务ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("任务组名")
    private String group;

    @ApiModelProperty("任务名称")
    private String name;

    @ApiModelProperty("调用目标字符串")
    private String invokeTarget;

    @ApiModelProperty("cron执行表达式")
    private String cronExpression;

    @ApiModelProperty("计划执行错误策略（0：放弃执行；1：立即执行；2：执行一次；）")
    private Integer misfirePolicy;

    @ApiModelProperty("是否并发执行（0：禁止；1：允许）")
    private Integer concurrent;

    @ApiModelProperty("备注信息")
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
