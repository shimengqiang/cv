package com.vector.dubbo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MusersDto implements Serializable {
    private static final long serialVersionUID = -6991085607480330052L;

    private Long id;

    private String cardId;

    private Date creatAt;

    private Date lastUpdate;

    private String name;

    private String phone;
}
