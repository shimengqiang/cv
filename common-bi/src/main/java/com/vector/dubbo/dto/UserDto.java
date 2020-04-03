package com.vector.dubbo.dto;

import java.io.Serializable;
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
public class UserDto implements Serializable {

    private String name;
    private String passWord;


}
