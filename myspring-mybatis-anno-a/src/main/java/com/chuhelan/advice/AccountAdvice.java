package com.chuhelan.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-04-23 12:44
 **/

@Aspect
//标识为切面
@Component
//定义组件

public class AccountAdvice {
    @Pointcut("execution(* com.chuhelan.service.*.*(..))")
    public void pointCut(){};
    @Before("pointCut()")
    public void before(JoinPoint jp){
        System.out.println("前置增强：开始账户操作！！");
    }
}