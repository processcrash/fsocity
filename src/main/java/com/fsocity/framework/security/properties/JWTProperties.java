package com.fsocity.framework.security.properties;

import lombok.Data;

/**
 * @author zail
 * @date 2022/1/24
 */
@Data
public class JWTProperties {
    // 头名称
    private String httpHeaderName = "Authorization";
    // 秘钥
    private String secret = "";
    // 过期时间(60 * 60 * 24 * 7)
    private Long expiration = 604800L;
    // token head
    private String tokenHead = "Bearer ";
}
