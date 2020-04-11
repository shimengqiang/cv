package com.vector.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.vector.dubbo.dao.mapper.UserMapper;
import com.vector.dubbo.dao.model.User;
import com.vector.dubbo.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Optional;

/**
 * @author shimengqiang
 * @Date 2020-03-27-14:24
 * @Version 1.0
 */
@Service(timeout = 2000,version = "1.0")
@Component
@Slf4j
public class UserDataServiceImpl implements UserDataServcie {
    @Autowired
    private UserMapper mapper;
    @Override
    public UserDto findUserByName(String name) {
        User user = mapper.findByName(name);
        UserDto userDto = new UserDto();
        Optional.ofNullable(user).ifPresent(user1 -> {
            BeanUtils.copyProperties(user1, userDto);
        });
        return userDto;
    }

    @Override
    public void register(UserDto userDto) {
//        mapper.insertUser(userDto.getName());
        log.info("register");
    }

    @Override
    public UserDto findById(Long id) {
        log.info(Thread.currentThread().getName());
        UserDto dto = new UserDto();
        User user = mapper.findById(id);
        if (user != null){
            BeanUtils.copyProperties(user, dto);
        }
        // try {
        //     //若大于 @Service(timeout = 2000,version = "1.0") 会重试3次
        //     Thread.sleep(2000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        return dto;
    }

    @PostConstruct
    public void test(){
        System.out.println(mapper.selectAll());
    }
}
    