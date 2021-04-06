package edu.niit.dao;

import edu.niit.domain.Account;

/**
 * @author： HP
 * @date： 2021-4-1
 * @description： AccountDao
 */
public interface AccountDao {
    /*根据id获得账户信息*/
    Account getAccountById(Integer id);
    /*实现转账功能*/
    Boolean transfer(Integer outId, Integer inId,double money);

}
