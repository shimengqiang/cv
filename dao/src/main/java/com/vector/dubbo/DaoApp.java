package com.vector.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author shimengqiang
 * @Date 2020-03-27-14:22
 * @Version 1.0
 */
//@EnableDubboConfiguration
@SpringBootApplication
@MapperScan(basePackages = "com.vector.dubbo.dao.mapper")
public class DaoApp {
    public static void main(String[] args) {
        System.out.println( "Hello World!" );
        SpringApplication.run(DaoApp.class,args);
    }
}
    