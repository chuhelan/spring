package com.chuhelan.dao;

import com.chuhelan.domain.Customer;
/**
 * @description:
 * @author: chuhelan
 * @create: 2021-05-18 08:18
 **/

public interface CustomerDao {
    public Customer findCustomerById(Integer id);
}