package com.chuhelan.dao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-18 13:48
 **/

public class TestWaiter {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Waiter waiter = ac.getBean("Proxy",Waiter.class);
        waiter.greetTo("John");
        ac.close();
    }
}