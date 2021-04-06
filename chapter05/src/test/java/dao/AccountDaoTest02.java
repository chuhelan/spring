package dao;

import com.chuhelan.config.SpringJDBCConfig;
import com.chuhelan.dao.AccountDao;
import com.chuhelan.domain.Account;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

/**
 * @author： HP
 * @date： 2021-3-31
 * @description： AccountDaoTest02
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringJDBCConfig.class})
class AccountDaoTest02 {
    @Autowired
    AccountDao accountDao;
    @Test
    void transfer() {
        List<Account> outUserBefore = accountDao.getAccountLike("Jack");
        List<Account> inUserBefore=accountDao.getAccountLike("John");
        System.out.println("转账前：");
        outUserBefore.forEach(System.out::println);
        inUserBefore.forEach(System.out::println);
        accountDao.transfer("Jack","John",200d);
        System.out.println("转账后：");
        List<Account> outUserAfter = accountDao.getAccountLike("Jack");
        List<Account> inUserAfter=accountDao.getAccountLike("John");
        outUserAfter.forEach(System.out::println);
        inUserAfter.forEach(System.out::println);
    }
}

