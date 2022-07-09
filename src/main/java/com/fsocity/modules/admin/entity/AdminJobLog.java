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
 * 定时任务调度日志表
 * </p>
 *
 * @author Zail
 * @since 2022-07-07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_admin_job_log")
@ApiModel(value = "AdminJobLog对象", description = "定时任务调度日志表")
public class AdminJobLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("任务日志ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("任务组名")
    private String group;

    @ApiModelProperty("任务名称")
    private String name;

    @ApiModelProperty("调用目标字符串")
    private String invokeTarget;

    @ApiModelProperty("日志信息")
    private String jobMessage;

    @ApiModelProperty("状态（0：正常；1：删除）")
    private Integer status;

    @ApiModelProperty("异常信息")
    private String exceptionInfo;

    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;


}
