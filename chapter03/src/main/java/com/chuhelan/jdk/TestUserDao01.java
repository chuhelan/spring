package com.chuhelan.jdk;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-18 15:06
 **/

public class TestUserDao01 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("UserAdviceAnnotation.xml");
        UserDao userDao = ac.getBean("userDao",UserDao.class);
        userDao.addUser();
        userDao.deleteUser();
    }
}