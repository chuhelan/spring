package com.chuhelan.dao;

import com.chuhelan.config.SpringJDBCConfig;
import com.chuhelan.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-30 09:08
 **/

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringJDBCConfig.class})
class UserDaoTest02 {
    @Autowired
    UserDao userDao;
    Logger logger = LoggerFactory.getLogger(UserDaoTest02.class);

    @Test
    void insertUser() {
        User user = new User("李阳", "123");
        int n = userDao.insertUser(user);
        logger.info(user.toString());
        Assertions.assertEquals(1, n);
    }

    @Test
    void deleteById() {
        int n = userDao.deleteById(200);
        logger.info("删除id=20");
        Assertions.assertEquals(1, n);
    }

    @Test
    public void updateUser() throws Exception {
        User user = userDao.getUserById(2);
        user.setAccount("李四");
        user.setPassword("111");
        int n = userDao.updateUser(user);
        assertEquals(1, n);
    }

    @Test
    public void getAllUser() throws Exception {
        List<User> list = userDao.getAllUser();
        list.forEach(user -> System.out.println(user));
    }

    @Test
    public void getUserById() throws Exception {
        User user = userDao.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void getUserLike() throws Exception {
        List<User> list = userDao.getUserLike("三");
        list.forEach(user -> System.out.println(user));
    }
}
