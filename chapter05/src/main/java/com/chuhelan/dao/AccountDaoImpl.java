package com.chuhelan.dao;

import com.chuhelan.domain.Account;
import com.chuhelan.mapper.AccountRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-30 10:48
 **/


@Repository("accountDao")
@Transactional
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    private final Logger logger =
            LoggerFactory.getLogger(AccountDaoImpl.class);

    /*@Override
    public int addAccount(Account account) {
    int n=0;
    String sql="insert into t_account(id,username,balance)
    value(null,?,?)";
    Object[] args={account.getUsername(),account.getBalance()};
    n=jdbcTemplate.update(sql,args);
    return n;
    }*/

    @Override
    public int addAccount(Account account) {
        int n = 0;
        String sql = "insert into t_account(id,username,balance)value(null, ?,?)";
        Object[] args = {account.getUsername(), account.getBalance()};
        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
        n = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
// return connection.prepareStatement(sql, (String[])args);
                PreparedStatement pst = connection.prepareStatement(sql, new String[]{"id"});
                pst.setString(1, (String) args[0]);
                pst.setDouble(2, (Double) args[1]);
                return pst;
            }
        }, keyHolder);
        Integer newId = keyHolder.getKey().intValue();
        account.setId(newId);
        logger.info("插入数据：" + account);
        return n;
    }

    @Override
    public int updateAccount(Account account) {
        int n = 0;
        String sql = "update t_account set username=?,balance= ? where id =?";
        Object[] args =
                {account.getUsername(), account.getBalance(), account.getId()};
        n = jdbcTemplate.update(sql, args);
        return n;
    }

    @Override
    public int deleteAccount(int id) {
        int n = 0;
        String sql = "delete from t_account where id=?";
        Object[] args = {id};
        n = jdbcTemplate.update(sql, args);

        return n;
    }

    /* 实现转账功能*/
    @Override
    public void transfer(String outUser, String inUser, Double money) {
// 收款人的操作
        String sql = "update t_account set balance=balance +? " + "where username = ?";
        Object[] args = {money, inUser};
        jdbcTemplate.update(sql, args);
// 为测试事务而加入
//        int n = 10 / 0;
// 汇款人的操作
        sql = "update t_account set balance=balance - ?" + "where username= ?";
        Object[] args1 = {money, outUser};
        jdbcTemplate.update(sql, args1);
    }

    @Override
    public boolean transfer(int outId, int inId, double money) {
        String sql = "update t_account set balance=balance - ? where id=?";
        Object[] args = {money, outId};
        int n1 = jdbcTemplate.update(sql, args);

        String sql1 = "update t_account set balance=balance + ? where id=?";
        Object[] args1 = {money, inId};
        int n2 = jdbcTemplate.update(sql1, args);

        if (n1 == 1 && n2 == 1){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public Account getAccountById(int id) {
        String sql = "select * from t_account where id=" + id;
        return jdbcTemplate.queryForObject(sql, new AccountRowMapper());
    }

    @Override
    public List<Account> getAllAccount() {
        String sql = "select * from t_account";
        return jdbcTemplate.query(sql, new AccountRowMapper());
//如果没有定义AccountRowMapper类，则上面的语句需要换成下面的语句：
// return jdbcTemplate.query(sql, new //BeanPropertyRowMapper<Account>(Account.class));
    }

    @Override
    public List<Account> getAccountLike(String keywords) {
        String sql = "select * from t_account where username like" + " '%" + keywords + "%' ";
        return jdbcTemplate.query(sql, new AccountRowMapper());
    }
}
