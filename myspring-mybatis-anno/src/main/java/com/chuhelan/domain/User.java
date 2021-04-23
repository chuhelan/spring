package com.chuhelan.domain;

import lombok.*;

import java.util.Date;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-04-22 14:11
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
}