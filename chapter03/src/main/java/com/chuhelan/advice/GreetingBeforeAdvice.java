package com.chuhelan.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-16 10:20
 **/

public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    private Logger log = LogManager.getLogger(GreetingBeforeAdvice.class);
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String name = (String) objects[0];   //得到目标对象的第一个参数
        log.info("向顾客"+name+"说再见！");
        System.out.println("How R U ! Mr " + name);
    }
}