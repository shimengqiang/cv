package com.vector.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.vector.dubbo.service.UserDataServcie;
import com.vector.dubbo.service.UserService;
import com.vector.dubbo.bean.in.UserInVo;
import com.vector.dubbo.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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

    @Reference
    private UserDataServcie service;

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
}
