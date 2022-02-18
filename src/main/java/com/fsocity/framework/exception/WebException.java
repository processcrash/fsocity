package com.fsocity.framework.exception;

/**
 * @author zail
 * @date 2022/2/18
 */
public class WebException extends RuntimeException {
    
    public WebException() {
    }
    
    public WebException(String message) {
        super(message);
    }
}
