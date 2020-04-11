package com.vector.dubbo;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author shimengqiang
 * @Date 2020-04-02-16:16
 * @Version 1.0
 */
@EnableDubboConfiguration
@SpringBootApplication
@ServletComponentScan("com.vector.dubbo.conf.filter")
public class WebApp {
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(WebApp.class,args);
    }
}
    