package com.chuhelan.domain;

import lombok.*;

import java.io.Serializable;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-04-20 08:12
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Role implements Serializable {
    private Integer id;
    private String name;
    private String description;
}