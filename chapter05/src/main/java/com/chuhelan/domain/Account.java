package com.chuhelan.domain;

import lombok.*;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-30 10:46
 **/

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//@ToString
public class Account {
    private Integer id;
    private String username;
    private double balance;

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
