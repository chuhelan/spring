package com.chuhelan.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"/beans01.xml"})
class MyBeanTest {
    @Autowired
    Bean bean;
    @Autowired
    @Qualifier("bean2")
    Bean bean2;
    @Autowired
    @Qualifier("bean3")
    Bean bean3;

    @Test
    public void test01() {
        System.out.println(bean3);
    }

//    @Test
//    public void test() {
//        System.out.println(bean);
//        System.out.println(bean2);
//    }

}