package com.chuhelan.service;

import com.chuhelan.dao.AccountDao;
import com.chuhelan.domain.Account;
import com.chuhelan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * @description:
 * @author: chuhelan
 * @create: 2021-04-23 12:43
 **/

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }
    @Override
    public int changeMoney(Integer fromId, Integer toId, Double money) {
        accountDao.subMoney(fromId,money);
// 模拟一个异常
// int result=1/0;
        accountDao.addMoney(toId,money);
        return 0;
    }
}

