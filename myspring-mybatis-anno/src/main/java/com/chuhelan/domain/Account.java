package com.chuhelan.domain;

import lombok.*;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-04-27 08:40
 **/


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private Integer id;
    private String username;
    private Double balance;
}
