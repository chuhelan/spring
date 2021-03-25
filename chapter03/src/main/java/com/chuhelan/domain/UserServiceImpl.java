package com.chuhelan.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-23 11:00
 **/

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    User user;


    @Override
    public boolean userLogin(User user) {
        if ("admin".equals(user.getAccount()) && "111".equals(user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}