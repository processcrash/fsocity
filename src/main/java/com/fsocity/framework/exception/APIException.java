package com.fsocity.framework.exception;

import com.fsocity.framework.web.CodeEnum;

/**
 * @author zail
 * @date 2022/1/24
 */
public class APIException extends RuntimeException {
    
    private CodeEnum errorCode;
    
    public APIException(CodeEnum errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
    
    public APIException(String message) {
        super(message);
    }
    
    public APIException(Throwable cause) {
        super(cause);
    }
    
    public APIException(String message, Throwable cause) {
        super(message, cause);
    }
    
    public CodeEnum getErrorCode() {
        return errorCode;
    }
}
