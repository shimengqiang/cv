package com.vector.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.vector.dubbo.api.DataServcie;
import com.vector.dubbo.dao.mapper.UserMapper;
import com.vector.dubbo.dao.model.User;
import com.vector.dubbo.entity.UserDto;
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
@Service
@Component
@Slf4j
public class MySQLDataService implements DataServcie {
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
    @PostConstruct
    public void test(){
        System.out.println(mapper.selectAll());
    }
}
    