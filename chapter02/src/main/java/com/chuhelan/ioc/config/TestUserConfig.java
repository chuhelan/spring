package com.chuhelan.ioc.config;

import com.chuhelan.ioc.bean.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-11 13:50
 **/

public class TestUserConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(UserConfig.class);
        User user1 = (User) ac.getBean("user1");
        User user2 = (User) ac.getBean("user2");
        System.out.println(user1);
        System.out.println(user2);
        User user3 = (User)ac.getBean("userStaticFactory");
        User user4 = (User)ac.getBean("userInstanceFactory");
        System.out.println(user3);
        System.out.println(user4);
    }
}