package com.vector.dubbo.conf;

import com.vector.dubbo.conf.filter.MyFilter1;
import com.vector.dubbo.conf.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author smq
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private UserInterceptor userInterceptor;
    @Autowired
    private MyFilter1 myFilter1;

    @Override public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(userInterceptor);
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(myFilter1);
        registration.addUrlPatterns("/*");
        registration.setName("myFilter1");
        // 过滤器的优先级
        registration.setOrder(1);
        return registration;
    }

}
