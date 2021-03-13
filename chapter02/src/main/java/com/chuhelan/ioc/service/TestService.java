package com.chuhelan.ioc.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-11 14:04
 **/

//@Service
public class TestService {
//    @PostConstruct
    public void initService() {
        System.out.println("initMethod. 传递一些参数，用来进行接受相关初始化数据");
    }

    public TestService() {
        System.out.println("构造方法");
    }

//    @PreDestroy
    public void destroyService() {
        System.out.println("destroyMethod,对象被销毁时做的工作");
    }
}