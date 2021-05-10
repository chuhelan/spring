package com.chuhelan.po;

/**
 * @description: 订单POJO
 * @author: chuhelan
 * @create: 2021-05-10 16:11
 **/

public class Orders {
    private Integer ordersId;
    private User user;

    public Integer getOrdersId() {
        return ordersId;
    }

    public void setOrdersId(Integer ordersId) {
        this.ordersId = ordersId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}