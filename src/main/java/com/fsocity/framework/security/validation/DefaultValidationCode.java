package com.fsocity.framework.security.validation;

import java.time.LocalDateTime;

/**
 * @author zail
 * @since 2018-09-27
 */
public class DefaultValidationCode implements ValidationCode {
    
    // 验证码
    private String code;
    
    // 过期时间
    private LocalDateTime expireTime;
    
    public DefaultValidationCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }
    
    public DefaultValidationCode(String code, LocalDateTime expireTime) {
        this.code = code;
        this.expireTime = expireTime;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    @Override
    public String getCode() {
        return code;
    }
    
    public LocalDateTime getExpireTime() {
        return expireTime;
    }
    
    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
    
    @Override
    public boolean isNonExpired() {
        return LocalDateTime.now().isBefore(expireTime);
    }
    
    /**
     * 查看匹配
     *
     * @param formCode
     */
    public boolean matches(String formCode) {
        if (isNonExpired()) {
            if (formCode != null) {
                return formCode.equals(this.getCode());
            }
        }
        
        return false;
    }
    
}
