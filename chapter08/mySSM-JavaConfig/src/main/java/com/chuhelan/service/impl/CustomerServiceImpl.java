package com.chuhelan.service.impl;

import com.chuhelan.domain.Customer;
import com.chuhelan.dao.CustomerDao;
import com.chuhelan.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-05-18 08:48
 **/

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;

    @Override
    public Customer findCustomerById(Integer id) {
        Optional<Customer> customerOptional =
                Optional.ofNullable(customerDao.findCustomerById(id));
        if (customerOptional.isPresent()) {
            Customer customer = customerOptional.get();
            return customer;
        }
        return null;
    }
}
