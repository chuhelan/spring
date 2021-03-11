package com.chuhelan.ioc.bean;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-11 13:37
 **/

public class UserinstanceFactory {
    public User createInstance() {
        System.out.println("工厂方法实例化");
        return new User();
    }
}