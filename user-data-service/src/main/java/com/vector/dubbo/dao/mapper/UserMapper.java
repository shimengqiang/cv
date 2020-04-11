package com.vector.dubbo.dao.mapper;

import com.vector.dubbo.dao.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    List<User> selectAll();

    User findByName(String name);

    @Select("select * from user where id = ${id}")
    User findById(@Param("id") Long id);
}