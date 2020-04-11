package com.vector.dubbo.conf.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author smq
 */

@Slf4j
@Component
public class UserInterceptor implements HandlerInterceptor {
    @Override public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
        Object handler) throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
       log.info("preHandle");
        return true;
    }

    @Override public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
        ModelAndView modelAndView) throws Exception {
        log.info("postHandle");
        request.setAttribute("endTime", System.currentTimeMillis());
    }

    @Override public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
        Exception ex) throws Exception {
        log.info("afterCompletion");
        long startTime = (long)request.getAttribute("startTime");
        long endTime = (long)request.getAttribute("endTime");
        log.info("URL {}, 耗时 {} 毫秒", request.getRequestURL(), (endTime - startTime));

    }
}
