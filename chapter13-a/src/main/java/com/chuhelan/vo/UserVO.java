package com.chuhelan.vo;

import com.chuhelan.po.User;

import java.util.List;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-05-10 16:56
 **/

public class UserVO {
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}