package edu.niit.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author： HP
 * @date： 2021-4-1
 * @description： Account
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Account {
    private Integer id;
    private String username;
    private double balance;
}
