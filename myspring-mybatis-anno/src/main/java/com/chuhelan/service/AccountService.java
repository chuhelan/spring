package com.chuhelan.service;

public interface AccountService {
    boolean transfer(Integer fromId,Integer toId,Double money);
}