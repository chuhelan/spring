package com.chuhelan.jdk;

import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-16 11:00
 **/

@Repository("userDao")
public class UserDaoImpl implements UserDao{
    @Override
    public void addUser() {
        System.out.println("添加用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");
    }
}