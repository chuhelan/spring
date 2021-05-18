package com.chuhelan.dao;

import com.chuhelan.domain.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-05-18 08:47
 **/

@Mapper
public interface CustomerDao {
    @Select("select * from t_customer where id=#{id}")
    public Customer findCustomerById(Integer id);
}