package com.chuhelan.dao;

import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-16 08:51
 **/
@Component("hello")
public class HelloImpl implements Hello{
    @Override
    public String sayHello() {
        return "Spring AOP";
    }
}