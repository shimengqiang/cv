package com.vector.dubbo;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@EnableDubboConfiguration
@SpringBootApplication
@MapperScan(basePackages = "com.vector.dubbo.dao.mapper")
public class ProductDataApp
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SpringApplication.run(ProductDataApp.class,args);
    }
}
