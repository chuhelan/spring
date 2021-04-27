package com.chuhelan.service;

import com.chuhelan.dao.AccountDao;
import com.chuhelan.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-04-27 08:43
 **/

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountDao accountDao;
    @Override

// @Transactional // 二选一即可

    public boolean transfer(Integer fromId, Integer toId, Double money) {
        int n1=accountDao.withdrawById(money,fromId);
        /*人为添加异常，查看是否回滚*/

// System.out.println(10/0);

        int n2=accountDao.depositById(money,toId);
        if(n1==1 && n2==1){
            return true;
        }else{
            return false;
        }
    }
}
