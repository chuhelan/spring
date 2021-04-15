package com.chuhelan.dao;

import com.chuhelan.domain.User;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class UserDaoTest {
    SqlSessionFactory sqlSessionFactory;
    SqlSession session;
    UserDao userDao;

    @BeforeEach
    void setUp() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        session = sqlSessionFactory.openSession();
        userDao = session.getMapper(UserDao.class);
    }

    @AfterEach
    void tearDown() {
        session.commit();
        session.close();
    }

    @Test
    void findUserByNameAndAddress() {
        User user = User.builder()
                .username("o")
                .address("江苏无锡")
                .build();
        final List<User> userByNameAndAddress = userDao.findUserByNameAndAddress(user);
        log.info(userByNameAndAddress.toString());

    }

    @Test
    void findCondition() {
        Integer id = 2;
        String username = "o";
        List<User> users;
        /*下面四个语句，依次释放出来进行验证*/
        users = userDao.findCondition(null, null);
//        users = userDao.findCondition(id, null);
//        users = userDao.findCondition(null, username);
//        users = userDao.findCondition(id, username);
        log.info(users.toString());
    }

    @Test
    void updateUser() throws ParseException {
        String birth = "2000-1-1";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthday = sdf.parse(birth);
        User user = User.builder()
                .id(1)
                .username("Max")
                .sex("male")
                .address("中国台湾")
                .birthday(birthday)
                .build();
        if (userDao.updateUser(user) > 0)
            log.info("更新了一条数据");
    }

    @Test
    void findUserByIds(){
        Integer[] ids = {1,2,4};
        List<User> users = userDao.findUserByIds(ids);
        log.info("查询到的信息为："+users.toString());
    }

    @Test
    void insertBatchUsers(){
    }
}






