package com.chuhelan;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-04-04 22:59
 **/

public class UserTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext("beans.xml");
        User user1 = (User) ac.getBean("user1");
        User user2 = (User) ac.getBean("user2");
        User user3 = (User) ac.getBean("user3");

        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);
    }
}