package com.vector.dubbo.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.vector.dubbo.bean.out.UserOutVo;
import com.vector.dubbo.dto.UserDto;
import com.vector.dubbo.service.UserDataServcie;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author smq
 */
@Component
@Slf4j
public class FutureTask {

    @Reference(version = "1.0")
    private UserDataServcie userService;

    /**
     * keepAliveTime 当线程数大于核心线程数时 多余线程存活的时间
     */
    private static ExecutorService executorService = new ThreadPoolExecutor(
        2,4, 1000, TimeUnit.SECONDS,
        new LinkedBlockingQueue<Runnable>(10),
        new ThreadFactoryBuilder().setNameFormat("User_Async_FutureTask-%d").setDaemon(true).build(),
        new ThreadPoolExecutor.CallerRunsPolicy());

    public UserOutVo aggregationData(final Long id){
        log.info("FutureTask的线程:" + Thread.currentThread());
        UserDto userDto = null, userDto1 = null, userDto2 = null,userDto3 = null,userDto4 = null;
        try {
            Future<UserDto> submit5 = executorService.submit(new Callable<UserDto>() {
                @Override public UserDto call() throws Exception {

                    return null;
                }
            });
            Future<UserDto> submit = executorService.submit(() -> {
                return this.userService.findById(id);
            });
            Future<UserDto> submit1 = executorService.submit(()-> userService.findById(id));
            Future<UserDto> submit2 = executorService.submit(()-> userService.findById(id));
            Future<UserDto> submit3 = executorService.submit(()-> userService.findById(id));
            Future<UserDto> submit4 = executorService.submit(()-> userService.findById(id));

            userDto = submit.get();
            userDto1 = submit1.get();
            userDto2 = submit2.get();
            userDto3 = submit3.get();
            userDto4 = submit4.get();

        }catch (Exception e){

        }

        return new UserOutVo(userDto, userDto1,userDto2,userDto3,userDto4);
    }


}
