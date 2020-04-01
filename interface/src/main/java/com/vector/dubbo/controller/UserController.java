package com.vector.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.vector.dubbo.api.PoductDataService;
import com.vector.dubbo.api.UserService;
import com.vector.dubbo.bean.in.UserInVo;
import com.vector.dubbo.entity.ProductDto;
import com.vector.dubbo.entity.UserDto;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author smq
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference
    private UserService service;

    @PostMapping("/login")
    public String login(String name, String password){
        return service.login(name, password);
    }
    @PostMapping("/register")
    public Object register(@RequestBody UserInVo userInVo){
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userInVo, userDto);
        service.register(userDto);
        return null;
    }
}
