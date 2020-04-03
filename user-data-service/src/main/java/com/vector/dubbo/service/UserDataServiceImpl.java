package com.vector.dubbo.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.vector.dubbo.dao.mapper.MusersMapper;
import com.vector.dubbo.dao.mapper.UserMapper;
import com.vector.dubbo.dao.model.Musers;
import com.vector.dubbo.dao.model.User;
import com.vector.dubbo.dto.BaseRequest;
import com.vector.dubbo.dto.MusersDto;
import com.vector.dubbo.dto.MusersQueryRequest;
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
@Service
@Component
@Slf4j
public class UserDataServiceImpl implements UserDataServcie {
    @Autowired
    private UserMapper mapper;
    @Autowired
    private MusersMapper musersMapper;
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
    public MusersDto findById(Long id) {
        MusersDto dto = new MusersDto();
        Musers musers = musersMapper.selectByPrimaryKey(id);
        BeanUtils.copyProperties(musers,dto);
        return dto;
    }

    @Override
    public MusersDto query(BaseRequest request) {
        MusersQueryRequest queryRequest = (MusersQueryRequest) request;
        MusersDto dto = new MusersDto();
        Musers musers = musersMapper.selectByPrimaryKey(queryRequest.getId());
        BeanUtils.copyProperties(musers,dto);
        return dto;
    }

    @PostConstruct
    public void test(){
        System.out.println(mapper.selectAll());
    }
}
    