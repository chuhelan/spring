package com.chuhelan.ioc.dao;


import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-09 18:59
 **/

@Repository("userDao")
public class UserDaoImpl implements UserDao{
    @Override
    public void say(){
        System.out.println("userDao says hello world!");
    }
}
