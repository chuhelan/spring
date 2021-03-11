package com.chuhelan.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-04 09:12
 **/


@RunWith(SpringJUnit4ClassRunner.class)//指定单元测试的环境
@ContextConfiguration(locations={"/applicationContext.xml"})//指定配置文件路径

public class UserDaoTest{
    @Autowired
    UserDao userDao;
    @Test
    public void say(){
            userDao.say();
    }
}