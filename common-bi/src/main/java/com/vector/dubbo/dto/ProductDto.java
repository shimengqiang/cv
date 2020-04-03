package com.vector.dubbo.dto;

import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author smq
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class ProductDto implements Serializable {
    private Long seckillId;

    private String name;

    private Integer number;

    private Date startTime;

    private Date endTime;

    private Date creatTime;
}
