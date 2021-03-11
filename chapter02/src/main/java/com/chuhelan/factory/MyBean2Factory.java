package com.chuhelan.factory;

import com.chuhelan.domain.Bean;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-09 10:20
 **/

public class MyBean2Factory {
    public MyBean2Factory() {
        System.out.println("bean工厂实例化");
    }
    public Bean createBean(){
        return new Bean();
    }
}