package com.chuhelan.staticFactory;

import com.chuhelan.domain.Bean;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-09 10:14
 **/

public class MyBeanFactory {
    public static Bean createBean(){
        return new Bean();
    }
}