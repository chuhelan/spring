package com.chuhelan.advice;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-16 08:53
 **/

@Aspect
@Component
public class HelloBefore {
    @Before("execution(* com.chuhelan.dao.Hello.*(..))")
    public void beforeMethod(){
        System.out.println("This is a before method......");
    }
}
