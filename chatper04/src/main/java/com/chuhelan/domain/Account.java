package com.chuhelan.domain;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-30 10:46
 **/


public class Account {
    private Integer id;  //账户余额
    private String username; //用户名
    private double balance;  //账户余额

    public Account() {
    }

    public Account(String username, double balance) {
        this.username = username;
        this.balance = balance;
    }

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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", balance=" + balance +
                '}';
    }
}
