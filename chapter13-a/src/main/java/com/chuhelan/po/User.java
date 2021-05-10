package com.chuhelan.po;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-05-10 15:55
 **/

public class User {

    private Integer id;
    private String username;
    private Integer password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }
}