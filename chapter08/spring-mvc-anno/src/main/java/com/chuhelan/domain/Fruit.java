package com.chuhelan.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-05-06 13:51
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Fruit {
    private String name;
    private Double price;
    private String producing_area;

}