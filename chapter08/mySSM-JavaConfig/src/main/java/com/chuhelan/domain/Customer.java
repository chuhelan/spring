package com.chuhelan.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-05-18 08:46
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Integer id;
    private String username;
    private String jobs;
    private String phone;
}
