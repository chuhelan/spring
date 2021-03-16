package com.chuhelan.factorybean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;



/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-16 12:25
 **/

public class MyAspect implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable{
        check_Permission();
        // 执行方法
        Object obj = mi.proceed();
        log();
        return obj;
    }
    public void check_Permission(){
        System.out.println("模拟检查权限...");
    }
    public void log(){
        System.out.println("模拟记录日志...");
    }

}