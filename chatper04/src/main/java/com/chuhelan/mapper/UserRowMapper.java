package com.chuhelan.mapper;

import com.chuhelan.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-25 13:56
 **/

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setAccount(resultSet.getString("account"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}