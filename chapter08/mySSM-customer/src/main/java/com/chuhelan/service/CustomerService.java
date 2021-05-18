package com.chuhelan.service;

import com.chuhelan.domain.Customer;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-05-18 08:21
 **/

public interface CustomerService {
    public Customer findCustomerById(Integer id);
}
