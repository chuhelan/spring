package com.chuhelan.dao;

import com.chuhelan.domain.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("/applicationContext.xml")
class AccountDaoTest {
    @Autowired
    AccountDao accountDao;

    @Test
    void addAccount() {
        Account account1 = new Account("Jack", 10000);
        Account account2 = new Account("Rose", 500);
        accountDao.addAccount(account1);
        accountDao.addAccount(account2);
    }

    @Test
    void updateAccount() {
        Account account = accountDao.getAccountById(2);
        account.setUsername("John");
        account.setBalance(10000);
        int n = accountDao.updateAccount(account);
        assertEquals(1, n);
    }

    @Test
    void deleteAccount() {
        int n = accountDao.deleteAccount(1);
        assertEquals(1, n);
    }

    @Test
    void transfer() {
        accountDao.transfer("Jack", "John", 200d);
    }

    @Test
    void getAccountById() {
        Account account;
        account = accountDao.getAccountById(5);
        System.out.println(account);
    }

    @Test
    void getAllAccount() {
        List<Account> list = accountDao.getAllAccount();
// list.forEach(account -> System.out.println(account));
        list.forEach(System.out::println);
    }

    @Test
    public void getAccountLike() throws Exception {
        List<Account> list = accountDao.getAccountLike("三");
        for (Account account : list) {
            System.out.println(account);
        }
    }
}

