package com.chuhelan.ioc.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-04 14:39
 **/

@Repository("testDao")
public class TestDaoImpl implements TestDao{
    @Override
    public void test() {
        System.out.println("使用java配置进行操作");
    }
}