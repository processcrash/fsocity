package com.fsocity.framework.util;

import com.fsocity.framework.web.FieldErrorInfo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zail
 * @since 2019/12/31
 */
public class ValidationUtils {
    
    /**
     * 处理校验后的结果集 BindingResult
     */
    public static List<FieldErrorInfo> getErrors(BindingResult bindingResult) {
        // 如果没有则不处理
        if (!bindingResult.hasErrors()) {
            return null;
        }
        
        List<FieldErrorInfo> result = new ArrayList<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            // 构建错误信息
            result.add(FieldErrorInfo.of(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        
        return result;
    }
    
}
