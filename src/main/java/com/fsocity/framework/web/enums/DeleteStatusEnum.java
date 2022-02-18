package com.fsocity.framework.web.enums;

import lombok.Getter;

/**
 * @author zail
 * @date 2022/2/18
 */
@Getter
public enum DeleteStatusEnum implements CodeEnum {
    
    EXISTS(0, "正常"),
    
    DELETED(1, "已删除"),
    
    ;
    
    private final Integer code;
    
    private final String message;
    
    DeleteStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
