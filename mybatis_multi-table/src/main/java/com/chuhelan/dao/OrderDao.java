package com.chuhelan.dao;

import com.chuhelan.domain.Order;

import java.util.List;

public interface OrderDao {
    List<Order> findAllOrders();

    Order findOrderById(Integer id);
}
