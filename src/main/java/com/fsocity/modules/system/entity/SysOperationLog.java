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
 * 操作日志记录
 * </p>
 *
 * @author Zail
 * @since 2022-01-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("sys_operation_log")
@ApiModel(value="SysOperationLog对象", description="操作日志记录")
public class SysOperationLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "日志主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "模块标题")
    private String title;

    @ApiModelProperty(value = "业务类型（0：其它；1：新增；2：修改；3：删除）")
    private Integer businessType;

    @ApiModelProperty(value = "方法名称")
    private String method;

    @ApiModelProperty(value = "请求方式")
    private String requestMethod;

    @ApiModelProperty(value = "操作对象类别（0：其它；1：后台用户；2：手机端用户）")
    private Integer operatorType;

    @ApiModelProperty(value = "操作人员")
    private String operatorName;

    @ApiModelProperty(value = "部门名称")
    private String departmentName;

    @ApiModelProperty(value = "请求URL")
    private String url;

    @ApiModelProperty(value = "主机地址")
    private String ip;

    @ApiModelProperty(value = "操作地点")
    private String location;

    @ApiModelProperty(value = "请求参数")
    private String param;

    @ApiModelProperty(value = "返回参数")
    private String result;

    @ApiModelProperty(value = "操作状态（0：正常；1：异常）")
    private Integer status;

    @ApiModelProperty(value = "错误消息")
    private String errorMsg;

    @ApiModelProperty(value = "操作时间")
    private Date operationTime;


}
