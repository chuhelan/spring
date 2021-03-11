package com.chuhelan.ioc.config;


import com.chuhelan.domain.User;
import com.chuhelan.ioc.bean.MyBean;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-09 10:48
 **/

@Configuration
@ComponentScan("com.chuhelan.ioc")
public class IoCConfig {
    @org.springframework.context.annotation.Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    MyBean getBean(){
        return new MyBean();
    }

    @Bean(name="user1")
    User getUser1(){
        return  new User("Tom",20);
    }
}