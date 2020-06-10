package com.vector.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.vector.dubbo.bean.in.UserInVo;
import com.vector.dubbo.dto.UserDto;
import com.vector.dubbo.service.UserDataServcie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author smq
 */

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    // @Reference(version = "1.0")
    private UserDataServcie service;
    @Autowired
    private FutureTask futureTask;

    @PostMapping("/login")
    public Object login(String name, String password){
        return service.findUserByName(name);
    }
    @PostMapping("/register")
    public Object register(@RequestBody UserInVo userInVo){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userInVo, userDto);
        service.register(userDto);
        return null;
    }

    @GetMapping("/{id}")
    public Object findUsers(@PathVariable Long id){
        return futureTask.aggregationData(id);
    }
}
