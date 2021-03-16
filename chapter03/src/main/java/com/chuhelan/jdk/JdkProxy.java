package com.chuhelan.jdk;

import com.chuhelan.aspect.MyAspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-16 11:01
 **/

public class JdkProxy implements InvocationHandler {
    //声明目标类接口
    private UserDao userDao;
    //创建代理方法
    public Object createProxy(UserDao userDao){
        this.userDao = userDao;
        // 1. 类加载
        ClassLoader classLoader = JdkProxy.class.getClassLoader();
        // 2. 被代理对象实现的所有接口
        Class[] clazz = userDao.getClass().getInterfaces();
        // 3.使用代理类，进行增强，返回的是代理后的对象
        return Proxy.newProxyInstance(classLoader,clazz,this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 声明切面
        MyAspect myAspect = new MyAspect();
        // 前增强
        myAspect.check_Permissions();
        // 在目标类上调用方法，并传入参数
        Object obj = method.invoke(userDao, args);
        myAspect.log();
        return obj;
    }
}