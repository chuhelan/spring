package com.chuhelan.ioc.config;

import com.chuhelan.ioc.service.TestService;
import  com.chuhelan.ioc.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {IocConfig.class})
class IocConfigTest {
    @Autowired
    TestService testService;
    @Autowired
    UserService userService;

    @Test
    public void test() {
        testService.test();
    }

    @Test
    public void userServiceTest() {
        userService.say();
    }
}