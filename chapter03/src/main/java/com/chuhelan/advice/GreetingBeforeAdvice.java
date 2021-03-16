package com.chuhelan.advice;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-16 10:20
 **/

public class GreetingBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        String name = (String) objects[0];   //得到目标对象的第一个参数
        System.out.println("How R U ! Mr " + name);
    }
}