package com.fsocity.framework.security.validation;

/**
 * 验证码接口
 *
 * @author zail
 * @since 2018-09-27
 */
public interface ValidationCode {
    
    /**
     * 获取验证码
     *
     * @return
     */
    String getCode();
    
    /**
     * 验证码是否未过期
     *
     * @return
     */
    boolean isNonExpired();
    
    /**
     * 检查是否匹配
     *
     * @param formCode
     * @return
     */
    boolean matches(String formCode);
    
}
