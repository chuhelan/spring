package com.chuhelan.controller;

import com.chuhelan.domain.Customer;
import com.chuhelan.service.CustomerService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-05-18 08:22
 **/

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;
    @RequestMapping("/customerById")
    public String findCustomerById(Integer id, Model model){
        Customer customer=customerService.findCustomerById(id);
        model.addAttribute("customer",customer);
        return "customer";
    }
}
