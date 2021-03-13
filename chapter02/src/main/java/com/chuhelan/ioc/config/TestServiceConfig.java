package com.chuhelan.ioc.config;

import com.chuhelan.ioc.service.PrototypeService;
import com.chuhelan.ioc.service.SingletonService;
import com.chuhelan.ioc.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-13 15:43
 **/

public class TestServiceConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(ServiceConfig.class);
        TestService testService = ac.getBean(TestService.class);
        System.out.println(testService);
        TestService testService1 = ac.getBean(TestService.class);
        System.out.println(testService1);

        SingletonService ss1 = ac.getBean(SingletonService.class);
        SingletonService ss2 = ac.getBean(SingletonService.class);
        System.out.println(ss1);
        System.out.println(ss2);

        PrototypeService ps1 = ac.getBean(PrototypeService.class);
        PrototypeService ps2 = ac.getBean(PrototypeService.class);
        System.out.println(ps1);
        System.out.println(ps2);

    }
}