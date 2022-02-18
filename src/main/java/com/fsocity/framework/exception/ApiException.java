package com.fsocity.framework.exception;

import com.fsocity.framework.web.enums.CodeEnum;

/**
 * @author zail
 * @date 2022/1/24
 */
public class ApiException extends RuntimeException {
    
    private CodeEnum errorCode;
    
    public ApiException(CodeEnum errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    
    public ApiException(String message) {
        super(message);
    }
    
    public ApiException(Throwable cause) {
        super(cause);
    }
    
    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public CodeEnum getErrorCode() {
        return errorCode;
    }
}
