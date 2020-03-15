package com.vector.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.vector.dubbo.api.UserService;
import com.vector.dubbo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author smq
 */
@Service
@Component
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public String login(String name, String password) {
        log.info("name {} password {}", name,password);
        return "success";
    }

    @Override
    public Boolean register(User user) {

        System.out.println(user.toString());

        return true;
    }
}
