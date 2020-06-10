package com.vector.dubbo;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.vector.dubbo.common.SpringContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;

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
		ConfigurableApplicationContext applicationContext = SpringApplication.run(WebApp.class, args);
		SpringContextHolder.setApplicationContext(applicationContext);
		for (String name : applicationContext.getBeanFactory().getBeanDefinitionNames()) {
			System.out.println(name);
		}
	}
}
    