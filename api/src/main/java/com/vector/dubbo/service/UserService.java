package com.vector.dubbo.service;

import com.vector.dubbo.entity.UserDto;

public interface UserService {

    String login(String name, String password);

    Boolean register(UserDto userDto);
}
