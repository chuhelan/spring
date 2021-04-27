package com.chuhelan.dao;

import com.chuhelan.domain.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
class AccountDaoTest {
    @Autowired
    AccountDao accountDao;
    @Test
    void insertAccount() {
    }
    @Test
    void depositById() {
        /*存款*/
        int n=accountDao.depositById(100d,2);
        Assertions.assertEquals(1,n);
    }
    @Test
    void withdrawById() {
        /*取款*/
        int n=accountDao.withdrawById(100d,2);
        Assertions.assertEquals(1,n);
    }
    @Test
    void findById() {
        Account account = accountDao.findById(2);
        System.out.println(account);
    }
}