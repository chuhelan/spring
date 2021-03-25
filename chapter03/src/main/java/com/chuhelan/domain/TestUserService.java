package com.chuhelan.domain;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-23 11:10
 **/

public class TestUserService {
    public static void main(String[] args) {
        ApplicationContext ac =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ac.getBean(UserService.class);
        User user = ac.getBean(User.class);
        System.out.println(userService.userLogin(user));
    }
}