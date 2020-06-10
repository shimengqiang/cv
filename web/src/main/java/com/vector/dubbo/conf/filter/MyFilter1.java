package com.vector.dubbo.conf.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author smq
 */
@Slf4j
@Component
public class MyFilter1 implements Filter {
    @Override public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        log.info("MyFilter1 过滤 request");
        //执行下一个锅过滤器或业务代码
        chain.doFilter(request, response);
        log.info("MyFilter1 处理 response");
        log.info("IP {}, 耗时 {} 毫秒", request.getRemoteHost(), (System.currentTimeMillis() - start));

    }

    @Override public void destroy() {

    }
}
