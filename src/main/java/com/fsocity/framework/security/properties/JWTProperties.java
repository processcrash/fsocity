package com.fsocity.framework.security.properties;

import lombok.Data;

/**
 * @author zail
 * @date 2022/1/24
 */
@Data
public class JWTProperties {
    // 是否开启JWT验证
    private boolean enable = false;
    // 头名称
    private String httpHeaderName = "Authorization";
    // 秘钥
    private String secret = "ciiz0eiwaTho2Zu4mohheitaeFe5aivoorahtha0eipivesh0rah2hohxie1eima";
    // 过期时间(60 * 60 * 24 * 7)
    private Long expiration = 604800L;
    // token head
    private String tokenHead = "Bearer ";
}
