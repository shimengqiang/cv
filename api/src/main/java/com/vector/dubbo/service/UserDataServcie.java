package com.vector.dubbo.service;

import com.vector.dubbo.dto.UserDto;

/**
 * @author shimengqiang
 * @Date 2020-03-27-14:24
 * @Version 1.0
 */
public interface UserDataServcie {

    UserDto findUserByName(String name);

    void register(UserDto userDto);
}
    