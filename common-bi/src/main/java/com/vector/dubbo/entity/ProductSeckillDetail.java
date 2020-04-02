package com.vector.dubbo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author smq
 */
 @AllArgsConstructor
 @NoArgsConstructor
 @Data
 @ToString
public class ProductSeckillDetail implements Serializable {

    private Long seckillId;

    private Long userPhone;

    private Byte state;

    private Date createTime;
}
