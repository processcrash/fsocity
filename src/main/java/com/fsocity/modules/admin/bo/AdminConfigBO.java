package com.fsocity.modules.admin.bo;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;

/**
 * @author zhangxq
 * @since 2022/9/23
 */
@Data
@Builder
public class AdminConfigBO {
    
    /*
    Integer、Long 类型的分别是:
        eq$Name        == $name
        lt$Name        < $name
        le$Name        <= $name
        gt$Name        > $name
        ge$Name        >= $name
        in$NameList    IN ($name, ...)
    BigDecimal 类型的分别是:
        eq$Name        == $name
        lt$Name        < $name
        le$Name        <= $name
        gt$Name        > $name
        ge$Name        >= $name
    String 类型的分别是：
        eq$Name             == $name
        like$Name           like '%$name%'
        likePrefix$Name     like '$name%'
        likeSuffix$Name     like '%$name'
    Date、LocalDateTime 类型的分别是：
        lt$Name        < $name
        le$Name        <= $name
        gt$Name        > $name
        ge$Name        >= $name
     */
    private Integer eqId;
    
    private Integer eqType;
    
    private String eqName;
    
    private String likeName;
    
    private String likePrefixName;
    
    private String likeSuffixName;
    
    private String eqKey;
    
    private String likeKey;
    
    private String likePrefixKey;
    
    private String likeSuffixKey;
    
    private String value;
    
    private String remark;
    
    private Integer status;
    
    private Integer createBy;
    
    private LocalDateTime createTime;
    
    private Integer updateBy;
    
    private LocalDateTime updateTime;
}
