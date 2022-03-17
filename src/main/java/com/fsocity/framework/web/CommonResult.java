package com.fsocity.framework.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommonResult<T> {
    
    // 结果代码
    private Integer code;
    
    // 结果信息说明
    private String message;
    
    // 结果数据
    private T data;
    
}
