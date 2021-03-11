package com.chuhelan.ioc.service;

import com.chuhelan.ioc.dao.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-04 14:56
 **/

@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public void test() {
        testDao.test();
        System.out.println("testService test");
    }
}