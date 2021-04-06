package com.chuhelan.dao;

import com.chuhelan.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    SqlSessionFactory sqlSessionFactory;
    SqlSession session;
    UserDao userDao;

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
        userDao = session.getMapper(UserDao.class);
    }


    @AfterEach
    void tearDown() {
//        要么在setUp()这个语句加入参数true
//        SqlSession session = sqlSessionFactory.openSession(true);
//        要么使用session.commit()
//        session.commit();
        session.close();
    }

    @Test
    void findAll() {
        List<User> allUser = userDao.findAll();
        allUser.forEach(System.out::println);
    }

    @Test
    void findUserById() {
        Integer id = 2;
        User user = userDao.findUserById(id);
        System.out.println(user);
    }

    @Test
    void updateUser() throws ParseException {
        String birthdayStr = "2000-12-25";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = sdf.parse(birthdayStr);
        User user = new User();
        user.setId(1);
        user.setUsername("Alex");
        user.setBirthday(birthday);
        user.setSex("female");
        user.setAddress("LA");
        System.out.println("Info before change :");

        User user1 = userDao.findUserById(user.getId());
//        complete change
        System.out.println(user1);
        userDao.updateUser(user);
        System.out.println("Info after change : ");
        user1 = userDao.findUserById(user.getId());
        System.out.println(user1);
    }

    @Test
    void insertUser() throws Exception {
        String birthdayStr = "1995-3-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = sdf.parse(birthdayStr);
        User user = new User("HAM", birthday, "female", "united states of america");
        System.out.println(user);
        userDao.insertUser(user);
        System.out.println(user);
    }

    @Test
    void deleteUserById() {
        System.out.println("Before Delete User");
        findAll();
        Integer id = 5;
        userDao.deleteUserById(id);
        System.out.println("delete success!");
        findAll();
    }

    @Test
    void findByMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id",4);
        map.put("username","HAM");
        User user = userDao.findByMap(map);
        System.out.println(user);
    }

}