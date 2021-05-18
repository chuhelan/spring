package com.chuhelan.service;

import com.chuhelan.domain.Customer;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-05-18 08:48
 **/

public interface CustomerService {
    public Customer findCustomerById(Integer id);
}