package com.fsocity.framework.web;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zail
 * @date 2022/2/18
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FieldErrorInfo {
    /**
     * 错误字段名称
     */
    private String name;
    
    /**
     * 错误信息
     */
    private String errorMessage;
    
    /**
     * 快速构建
     */
    public static FieldErrorInfo of(String name, String errorMessage) {
        return new FieldErrorInfo(name, errorMessage);
    }
}
