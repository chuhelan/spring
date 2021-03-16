package com.chuhelan.aspect;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-16 10:55
 **/

public class MyAspect {
    public void check_Permissions(){
        System.out.println("模拟检查权限...");
    }
    public void log(){
        System.out.println("模拟记录日志...");
    }
}