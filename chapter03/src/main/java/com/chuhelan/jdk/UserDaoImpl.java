package com.chuhelan.jdk;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-16 11:00
 **/

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