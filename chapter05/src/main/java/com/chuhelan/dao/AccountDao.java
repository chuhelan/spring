package com.chuhelan.dao;

import com.chuhelan.domain.Account;

import java.util.List;

public interface AccountDao {
    int addAccount(Account account);

    int updateAccount(Account account);

    int deleteAccount(int id);

    void transfer(String outUser, String inUser, Double money);

    boolean transfer(int outId, int inId, double money);

    Account getAccountById(int id);

    List<Account> getAllAccount();

    List<Account> getAccountLike(String keywords);

}
