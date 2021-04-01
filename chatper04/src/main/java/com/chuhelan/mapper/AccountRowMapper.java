package com.chuhelan.mapper;

import com.chuhelan.domain.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-30 10:52
 **/

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet resultSet, int i) throws SQLException {
        Account account = new Account();
        account.setId(resultSet.getInt("id"));
        account.setUsername(resultSet.getString(2));
        account.setBalance(resultSet.getDouble(3));
        return account;
    }
}