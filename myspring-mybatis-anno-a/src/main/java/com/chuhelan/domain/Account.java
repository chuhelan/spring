package com.chuhelan.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-04-23 12:40
 **/

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account implements Serializable {
    private int id;
    private String username;
    private Double balance;
}