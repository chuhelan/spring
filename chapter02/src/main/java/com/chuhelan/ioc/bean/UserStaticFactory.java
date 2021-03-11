package com.chuhelan.ioc.bean;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-11 13:39
 **/

public class UserStaticFactory {
    private static User instance = new User();
    public static User createInstance(){
        System.out.println("静态工厂实例化");
        return instance;
    }
}