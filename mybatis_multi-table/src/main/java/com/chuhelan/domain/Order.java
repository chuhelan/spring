package com.chuhelan.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-04-15 14:05
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order implements Serializable {
    private Integer id;
    private Date createtime;
    private double price;
    private String remark;

//一个用户有多个订单，但一个订单只有一个用户，这种多对一的关系
// 对订单来说在mybatis中称为一对一的关系

    private User user;


}