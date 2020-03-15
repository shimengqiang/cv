package com.vector.dubbo.api;

import com.vector.dubbo.entity.User;

public interface UserService {

    String login(String name, String password);

    Boolean register(User user);
}
