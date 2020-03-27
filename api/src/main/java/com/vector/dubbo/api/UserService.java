package com.vector.dubbo.api;

import com.vector.dubbo.entity.UserDto;

public interface UserService {

    String login(String name, String password);

    Boolean register(UserDto userDto);
}
