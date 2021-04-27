package com.chuhelan.dao;

import com.chuhelan.domain.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findById(Integer id);
    int insert(User user);

}
