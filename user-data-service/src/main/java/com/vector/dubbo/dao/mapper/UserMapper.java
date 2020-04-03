package com.vector.dubbo.dao.mapper;

import com.vector.dubbo.dao.model.User;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();

    User findByName(String name);
}