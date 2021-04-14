package com.chuhelan.dao;

import com.chuhelan.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoAnnoTest {
    SqlSessionFactory sqlSessionFactory;
    SqlSession session;
    UserDaoAnno userDao;
    private Logger log = LoggerFactory.getLogger(UserDaoAnnoTest.class);

    @BeforeEach
    void setUp() throws IOException {
        /*1 、加载配置文件*/
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        /*2、根据配置文件创建SqlSessionFactory工厂对象*/
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        /*3、通过SqlSession创建session核心接口（发送sql语句
         * 理解为一个数据库连接*/
        session = sqlSessionFactory.openSession(true);
        /*4、通过SqlSession获取接口的实现类对象UserDao*/
        userDao = session.getMapper(UserDaoAnno.class);

    }


    @AfterEach
    void tearDown() {
        session.close();
    }

    @Test
    void findAll() {
        List<User> allUser = userDao.findAll();
        allUser.forEach(System.out::println);
    }

    @Test
    void insertUser() {
        String birthdayStr = "1995-3-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = null;
        try {
            birthday = sdf.parse(birthdayStr);
        } catch (ParseException e) {
            e.printStackTrace();
            log.error("插入出现了问题");
        }
        User user = new User("HAM", birthday, "female", "united states of america");
        System.out.println(user);
        userDao.insertUser(user);
        System.out.println(user);
    }

    @Test
    void updateUser() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String birStr = "2002-1-1";
        Date birthday = sdf.parse(birStr);
        User user = new User(11, "Jerry", birthday, "男", "上海");
        userDao.updateUser(user);
        User userById = userDao.findUserById(11);
        System.out.println(userById);

    }

    @Test
    void deleteUserById() {
        System.out.println("Before Delete User");
        findAll();
        Integer id = 4;
        userDao.deleteUserById(id);
        System.out.println("delete success!");
        findAll();
    }

    @Test
    void findUserById() {
        User user = userDao.findUserById(12);
        System.out.println(user);
    }
}