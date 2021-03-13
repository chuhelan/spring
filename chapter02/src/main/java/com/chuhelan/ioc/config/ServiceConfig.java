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
    @Bean(initMethod = "initService", destroyMethod = "destroyService")
    public TestService getService(){
        return new TestService();
    }

}