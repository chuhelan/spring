package com.chuhelan.cglib;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-16 10:44
 **/

public class CglibTest {
    public static void main(String[] args) {
        //创建代理对象
        CglibProxy cglibProxy = new CglibProxy();
        //创建目标对象
        UserDao userDao = new UserDao();
        //获取增强后的对象
        UserDao userDao1 = (UserDao)cglibProxy.createProxy(userDao);
        //执行方法
        userDao1.addUser();
        userDao1.deleteUser();
    }
}