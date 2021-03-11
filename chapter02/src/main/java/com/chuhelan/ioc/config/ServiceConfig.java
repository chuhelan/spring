package com.chuhelan.ioc.config;

import com.chuhelan.ioc.service.PrototypeService;
import com.chuhelan.ioc.service.SingletonService;
import com.chuhelan.ioc.service.TestService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-11 14:09
 **/

@Configuration
@ComponentScan("com.chuhelan.ioc.service")
public class ServiceConfig {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac =
                new AnnotationConfigApplicationContext(ServiceConfig.class);
        TestService testService = ac.getBean(TestService.class);
        System.out.println(testService);

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