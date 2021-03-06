package com.chuhelan.controller;

import com.chuhelan.po.Orders;
import com.chuhelan.po.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-05-10 16:13
 **/

@Controller
public class OrdersController {
    //  向订单查询页面跳转
    @RequestMapping("/tofindOrdersWithUser")
    public String tofindOrderWithUser() {
        return "orders";
    }

    //    查询订单和用户信息
    @RequestMapping("/findOrdersWithUser")
    public String findOrderWithUser(Orders orders) {
        Integer orderId = orders.getOrdersId();
        User user = orders.getUser();
        String username = user.getUsername();
        System.out.println("orderId=" + orderId);
        System.out.println("username=" + username);
        return "success";
    }
}