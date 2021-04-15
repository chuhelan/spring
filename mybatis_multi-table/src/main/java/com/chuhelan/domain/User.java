package com.chuhelan.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Date;


/**
 * @description:
 * @author: chuhelan
 * @create: 2021-04-15 14:02
 **/

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User implements Serializable {
    private Integer id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
}