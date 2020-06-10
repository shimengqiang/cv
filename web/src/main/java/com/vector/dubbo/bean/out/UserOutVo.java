package com.vector.dubbo.bean.out;

import com.vector.dubbo.dto.UserDto;
import lombok.Data;

/**
 * @author smq
 */
@Data
public class UserOutVo {

    private UserDto dto;
    private UserDto dto1;
    private UserDto dto2;
    private UserDto dto3;
    private UserDto dto4;

    public UserOutVo(UserDto dto, UserDto dto1, UserDto dto2,UserDto dto3, UserDto dto4) {
        this.dto = dto;
        this.dto1 = dto1;
        this.dto2 = dto2;
        this.dto3 = dto3;
        this.dto4 = dto4;
    }

}
