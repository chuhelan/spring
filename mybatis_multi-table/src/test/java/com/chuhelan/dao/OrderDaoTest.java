package com.chuhelan.dao;

import com.chuhelan.domain.Order;
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
class OrderDaoTest {

    InputStream in;
    SqlSessionFactory sqlSessionFactory;
    SqlSession session;
    OrderDao orderDao;

    @BeforeEach
    void setUp() throws IOException {
        String resource = "mybatis-config.xml";
        in = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        session = sqlSessionFactory.openSession();
        orderDao = session.getMapper(OrderDao.class);
    }

    @AfterEach
    void tearDown() throws IOException {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    void findAllOrders() {
        List<Order> allOrders = orderDao.findAllOrders();
        log.info(allOrders.toString());
    }

    @Test
    void findOrderById() {
        final Order orderById = orderDao.findOrderById(1);
        System.out.println("orderById="+orderById);
    }
}