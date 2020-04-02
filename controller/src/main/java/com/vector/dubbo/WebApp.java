package com.vector.dubbo;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shimengqiang
 * @Date 2020-04-02-16:16
 * @Version 1.0
 */
@EnableDubboConfiguration
@SpringBootApplication
public class WebApp {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(WebApp.class,args);
    }
}
    