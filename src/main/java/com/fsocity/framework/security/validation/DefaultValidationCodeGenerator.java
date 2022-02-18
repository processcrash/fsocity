package com.fsocity.framework.security.validation;

/**
 * @author zail
 * @since 2018-09-27
 */
public class DefaultValidationCodeGenerator implements ValidationCodeGenerator {
    
    // 验证码长度
    private int length;
    
    // 过期时间
    private int expireIn;
    
    @Override
    public ValidationCode generate() {
        String code = ValidateCodeUtils.randomChars(length);
        return new DefaultValidationCode(code, expireIn);
    }
    
    public int getLength() {
        return length;
    }
    
    public void setLength(int length) {
        this.length = length;
    }
    
    public int getExpireIn() {
        return expireIn;
    }
    
    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }
    
}
