package com.chuhelan.service;

import com.chuhelan.config.ApplicationConfig;
import com.chuhelan.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class) //单元测试
@ContextConfiguration(classes={ApplicationConfig.class}) //加载应用配置文件类
@Slf4j //使用slf4j日志门面
class AccountServiceTest {
    @Autowired
    AccountService accountService;
    @Test
    void findAll() {
        List<Account> allAccount = accountService.findAll();
        System.out.println("获取所有用户");
        allAccount.forEach(System.out::println);
        log.info("查询所有用户");
        log.info(allAccount.toString());
    }
    @Test
    void changeMoney() {
        List<Account> allAccount = accountService.findAll();
        System.out.println("获取所有用户");
        allAccount.forEach(System.out::println);
        accountService.changeMoney(1,2,200d);
        allAccount = accountService.findAll();
        System.out.println("获取所有用户");
        allAccount.forEach(System.out::println);
    }
}
