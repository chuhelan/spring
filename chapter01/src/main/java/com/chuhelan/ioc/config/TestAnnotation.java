package com.chuhelan.ioc.config;

import com.chuhelan.ioc.service.TestService;
import com.chuhelan.ioc.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-04 14:42
 **/

public class TestAnnotation {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext
                ac = new AnnotationConfigApplicationContext(IocConfig.class);
//        TestService testService = ac.getBean(TestService.class);
//        testService.test();
        UserService userService=ac.getBean(UserService.class);
        userService.say();
    }


}