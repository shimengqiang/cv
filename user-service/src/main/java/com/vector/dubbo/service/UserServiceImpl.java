package com.vector.dubbo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.vector.dubbo.api.UserDataServcie;
import com.vector.dubbo.api.UserService;
import com.vector.dubbo.entity.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author smq
 */
@Service
@Component
@Slf4j
public class UserServiceImpl implements UserService {
    @Reference
    private UserDataServcie userDataServcie;

    @Override
    public String login(String name, String password) {
        UserDto userDto = userDataServcie.findUserByName(name);
        log.info("name {} password {}, {}", name,password, userDto.toString());
        return "success";
    }

    @Override
    public Boolean register(UserDto userDto) {

        System.out.println(userDto.toString());

        return true;
    }
}
