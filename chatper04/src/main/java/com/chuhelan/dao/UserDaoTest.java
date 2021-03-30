package com.chuhelan.dao;

import com.chuhelan.domain.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-25 14:22
 **/

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
class UserDaoTest {

    Logger logger = LogManager.getLogger(UserDaoTest.class);

    @Autowired
    UserDao userDao;


    @Test
    void insertUser() {
        User user = new User("aaa", "111");
        int n = userDao.insertUser(user);
        logger.info("user:" + user);
        assertEquals(1, n);
    }

    @Test
    void deleteById() {
        int n = userDao.deleteById(4);
        Assertions.assertEquals(1, n);
    }

    @Test
    void updateUser() {
        User user = userDao.getUserById(2);
        user.setAccount("李四");
        user.setPassword("111");
        int n = userDao.updateUser(user);
        Assertions.assertEquals(1, n);
    }


    @Test
    void getAllUser() {
        List<User> list = userDao.getAllUser();
        list.forEach(user -> System.out.println(user));
/*for(User user:list){
System.out.println(user);
}*/
    }

    @Test
    void getUserById() {
        User user = userDao.getUserById(1);
        System.out.println(user);
    }

    @Test
    void getUserLike() {
        List<User> list = userDao.getUserLike("三");
        for (User user : list) {
            System.out.println(user);
        }
    }
}