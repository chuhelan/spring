package com.chuhelan.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-16 10:28
 **/

public class TestProxy {
    public static void main(String[] args) {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Waiter proxy = (Waiter) ac.getBean("proxy");
        proxy.serveTo("Tom");
    }
}