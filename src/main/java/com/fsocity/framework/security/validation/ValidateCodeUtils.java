package com.fsocity.framework.security.validation;

import java.util.Random;

/**
 * @author zail
 * @since 2018-09-27
 */
public class ValidateCodeUtils {
    
    // 验证码字符集
    private static final char[] VALIDATION_CODE_CHARS = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'
    };
    
    public static String randomChars(int length) {
        StringBuilder result = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int n = random.nextInt(VALIDATION_CODE_CHARS.length);
            result.append(VALIDATION_CODE_CHARS[n]);
        }
        
        return result.toString();
    }
    
}
