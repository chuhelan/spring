package com.chuhelan.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-23 10:59
 **/


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String account;
    String password;
}