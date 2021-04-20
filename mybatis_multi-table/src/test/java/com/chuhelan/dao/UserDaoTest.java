package com.chuhelan.dao;

import com.chuhelan.domain.User;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class UserDaoTest {

    InputStream in;
    SqlSessionFactory sqlSessionFactory;
    SqlSession session;
    UserDao userDao;

    @BeforeEach
    void setUp() throws IOException {
        String resource = "mybatis-config.xml";
        in = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        session = sqlSessionFactory.openSession();
        userDao = session.getMapper(UserDao.class);
    }

    @AfterEach
    void tearDown() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
        User user = userDao.findById(1);
        log.info("user:" + user);
    }

    @Test
    void findByIdWithRoles() {
        User user = userDao.findByIdWithRoles(1);
        log.info("带角色的user:" + user);
    }

    @Test
    void findByUsernameLike() {
        List<User> users = userDao.findByUsernameLike("o");
        log.info("查询姓名中有o的用户：" + users.toString());
    }

    @Test
    void findAllUserPageHelper() {
        PageHelper.startPage(1, 3);
//        Page<User> page = PageHelper.startPage(2,3);
        List<User> users = userDao.findAll();
        System.out.println(users.toString());
        PageInfo<User> pageInfo = new PageInfo<>(users);
        System.out.println("总条数：" + pageInfo.getTotal());
        System.out.println("总页数：" + pageInfo.getPages());
        System.out.println("当前页：" + pageInfo.getPageNum());
        System.out.println("每页显示长度："+pageInfo.getPageSize());

    }
}