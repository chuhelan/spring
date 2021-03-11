package com.chuhelan.ioc.service;

import com.chuhelan.demo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-09 08:50
 **/

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    //使用setter方法注入
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void say() {
        this.userDao.say();
        System.out.println("userServer say hello world");
    }
}