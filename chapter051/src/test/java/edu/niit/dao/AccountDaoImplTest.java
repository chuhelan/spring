package edu.niit.dao;

import edu.niit.domain.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author： HP
 * @date： 2021-4-1
 * @description： AccountDaoImplTest
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
class AccountDaoImplTest {
    @Autowired
    AccountDao accountDao;

    @Test
    void getAccountById() {
        Account account1 = accountDao.getAccountById(3);
        System.out.println(account1);
        Account account2 = accountDao.getAccountById(2);
        System.out.println(account2);
    }

    @Test
    void transfer() {
        Account account1 = accountDao.getAccountById(3);
        System.out.println(account1);
        Account account2 = accountDao.getAccountById(2);
        System.out.println(account2);
        accountDao.transfer(2, 3, 100);

    }
}