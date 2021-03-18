package com.chuhelan.jdk;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("UserAdvice.xml");
    UserDao userDao = ac.getBean("userDao",UserDao.class);

    @Test
    void deleteUser(){
        userDao.deleteUser();
    }

    @Test
    void addUser(){
        userDao.addUser();
    }

}