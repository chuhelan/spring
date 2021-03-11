package com.chuhelan.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-04 09:09
 **/

public class TestIoc {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//        UserDao userDao = (UserDao) ac.getBean("userDao");
//        userDao.say();
        UserDao userDao = ac.getBean("userDao", UserDao.class);
        userDao.say();
    }
}