package com.chuhelan.ioc.config;

import com.chuhelan.ioc.bean.User;
import com.chuhelan.ioc.bean.UserStaticFactory;
import com.chuhelan.ioc.bean.UserinstanceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-11 13:41
 **/

@Configuration
public class UserConfig {

    @Bean(value="user1")
    public User getUser(){
        return new User("张三",30);
    }

    @Bean(value="user2")
    public User getUser2(){
        return new User("李四",20);
    }

    @Bean(value = "userStaticFactory")
    public User getUserStaticFactory(){
        return UserStaticFactory.createInstance();
    }

    @Bean("userInstanceFactory")
    public User getUserInstanceFactory(){
        return new UserinstanceFactory().createInstance();
    }

}