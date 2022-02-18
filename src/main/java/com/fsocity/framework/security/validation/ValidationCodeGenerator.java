package com.fsocity.framework.security.validation;

/**
 * 验证码生成器接口
 *
 * @author zail
 * @since 2018-09-27
 */
public interface ValidationCodeGenerator {
    
    /**
     * 生成验证码
     *
     * @return 验证码实例
     */
    ValidationCode generate();
    
}
