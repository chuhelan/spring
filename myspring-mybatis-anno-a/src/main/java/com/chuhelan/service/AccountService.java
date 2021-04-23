package com.chuhelan.service;

import com.chuhelan.domain.Account;
import java.util.List;


public interface AccountService {
    List<Account> findAll();
    int changeMoney(Integer fromId,Integer toId,Double money);
}
