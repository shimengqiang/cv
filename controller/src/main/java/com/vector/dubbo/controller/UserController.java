package com.vector.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.vector.dubbo.dto.MusersQueryRequest;
import com.vector.dubbo.service.ProcessService;
import com.vector.dubbo.service.UserDataServcie;
import com.vector.dubbo.bean.in.UserInVo;
import com.vector.dubbo.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author smq
 */

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Reference
    private UserDataServcie service;
    @Autowired
    private ProcessService processService;

    private  static final Map<String, Method> map = new ConcurrentHashMap<>();

    @PostConstruct
    public void init(){
        Method[] declaredMethods = service.getClass().getDeclaredMethods();
        for (Method m : declaredMethods) {
            m.setAccessible(false);
            map.put(m.getName(), m);
        }
    }
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
    @PostMapping("/queryMuser")
    public Object findById(@RequestBody MusersQueryRequest request) throws InvocationTargetException, IllegalAccessException {
//        MusersDto dto = new MusersDto();
//        Method method = map.get("findById");
//        if (method == null){
//            Method[] declaredMethods = service.getClass().getDeclaredMethods();
//            for (Method m : declaredMethods) {
//                m.setAccessible(false);
//                map.put(m.getName(), m);
//            }
//            method = map.get("findById");
//        }
//        dto = (MusersDto)method.invoke(service, id);


        return processService.invoke("query", request);
    }
}
