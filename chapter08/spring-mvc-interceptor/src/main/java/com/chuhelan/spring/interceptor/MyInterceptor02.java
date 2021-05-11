package com.chuhelan.spring.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-05-11 09:34
 **/

public class MyInterceptor02 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        System.out.println("1.MyInterceptor02--->preHandle.....");
// 对拦截器的请求进行放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse
            response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("3.MyInterceptor02--->postHandle......");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) throws
            Exception {
        System.out.println("4.MyInterceptor02--->afterCompletion.....");
    }

}