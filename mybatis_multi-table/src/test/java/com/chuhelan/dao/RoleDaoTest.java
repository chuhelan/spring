package com.chuhelan.dao;

import com.chuhelan.domain.Role;
import com.chuhelan.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class RoleDaoTest {

    InputStream in;
    SqlSessionFactory sqlSessionFactory;
    SqlSession session;
    RoleDao roleDao;

    @BeforeEach
    void setUp() throws IOException {
        String resource = "mybatis-config.xml";
        in = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        session = sqlSessionFactory.openSession();
        roleDao = session.getMapper(RoleDao.class);
    }

    @AfterEach
    void tearDown() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    void findAllRoles() {
        List<Role> allRoles = roleDao.findAllRoles();
        log.info(allRoles.toString());

    }

    @Test
    void findRoleById(){
        Role user = roleDao.findRoleById(4);
        log.info("找到的角色为:"+user);
    }

    @Test
    void findRoleByUserId(){
        List<Role> roles = roleDao.findRoleByUserId(1);
        log.info("根据用户id查询角色信息："+roles.toString());
    }
}