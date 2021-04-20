package com.chuhelan.dao;

import com.chuhelan.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {

    /*根据姓名和地址实现动态查询
     * 如果姓名和地址都存在则两个条件
     * 如果只有姓名或者地址，则按单条件查询
     * 如果姓名和地址都不存在，则查询所有信息
     * */

    List<User> findUserByNameAndAddress(User user);

    /*根据id和username实现动态查询，同时存在则满足两个条件* */

    List<User> findCondition(@Param("id") Integer id, @Param("username") String username);

//    如果User对象之中有对应的数据则进行修改，
//    没有就保持原来的数据不变

    int updateUser(User user);

//    查询一组id用户信息
//     @Param表示指定参数，xml中则可以在collection上写ids,否则则需要写arrays

    List<User> findUserByIds(@Param("ids") Integer[] ids);

    int insertBatchUsers(List<User> users);

}
