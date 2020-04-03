package com.vector.dubbo.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.proxy.InvokerInvocationHandler;
import com.vector.dubbo.dto.BaseRequest;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ProcessService {

    @Reference
    private UserDataServcie service;
    private  static final Map<String, Method> map = new ConcurrentHashMap<>();

    @PostConstruct
    public void init(){
        Method[] declaredMethods = service.getClass().getDeclaredMethods();
        //TODO 
//        ((InvokerInvocationHandler) service).
        for (Method m : declaredMethods) {
            m.setAccessible(true);
            map.put(m.getName(), m);
        }
    }

    public Object invoke(String methodName, BaseRequest request){
        Method method = map.get(methodName);
        if (method == null){
            Method[] declaredMethods = service.getClass().getDeclaredMethods();
            for (Method m : declaredMethods) {
                m.setAccessible(false);
                map.put(m.getName(), m);
            }
        }
        method = map.get(methodName);
        try {
            return method.invoke(service, request);
        } catch (IllegalAccessException e) {


        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
