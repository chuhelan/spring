package com.chuhelan.domain;

import lombok.*;

import java.util.Date;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-04-13 08:27
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
}