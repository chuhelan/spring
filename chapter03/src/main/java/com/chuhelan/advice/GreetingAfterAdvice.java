package com.chuhelan.advice;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-18 13:47
 **/

public class GreetingAfterAdvice implements AfterReturningAdvice {
    private Logger log = LogManager.getLogger(GreetingAfterAdvice.class);

    @Override
    public void afterReturning(Object o, Method method,
                               Object[] objects, Object o1) throws Throwable {
        String name = (String)objects[0];
        log.info("向顾客"+name+"说再见！");
        System.out.println("See you later ,Mr "+name);
    }
}