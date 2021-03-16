package com.chuhelan.dao;

import com.chuhelan.config.HelloConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-16 09:04
 **/

public class TestHello {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(HelloConfig.class);
        Hello hello = (Hello)ac.getBean("hello");
        System.out.println(hello.sayHello());
    }
}