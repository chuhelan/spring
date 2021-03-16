package com.chuhelan.dao;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-16 10:19
 **/

public class NaiveWaiter implements Waiter {
    @Override
    public void greetTo(String name) {
        System.out.println("greet to " + name);
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serve to " + name);
    }
}