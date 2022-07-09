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
 * 操作日志记录
 * </p>
 *
 * @author Zail
 * @since 2022-07-07
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("tb_admin_operation_log")
@ApiModel(value = "AdminOperationLog对象", description = "操作日志记录")
public class AdminOperationLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("日志ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("模块标题")
    private String title;

    @ApiModelProperty("业务类型（0：其它；1：新增；2：修改；3：删除）")
    private Integer businessType;

    @ApiModelProperty("方法名称")
    private String method;

    @ApiModelProperty("请求方式")
    private String requestMethod;

    @ApiModelProperty("操作对象类别（0：其它；1：后台用户；2：手机端用户）")
    private Integer operatorType;

    @ApiModelProperty("操作人员")
    private String operatorName;

    @ApiModelProperty("部门名称")
    private String departmentName;

    @ApiModelProperty("请求URL")
    private String url;

    @ApiModelProperty("主机地址")
    private String ip;

    @ApiModelProperty("操作地点")
    private String location;

    @ApiModelProperty("请求参数")
    private String param;

    @ApiModelProperty("返回参数")
    private String result;

    @ApiModelProperty("状态（0：正常；1：删除）")
    private Integer status;

    @ApiModelProperty("错误消息")
    private String errorMsg;

    @ApiModelProperty("操作时间")
    private LocalDateTime operationTime;


}
