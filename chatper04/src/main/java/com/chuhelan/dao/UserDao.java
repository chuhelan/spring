package com.chuhelan.dao;


import com.chuhelan.domain.User;

import java.util.List;

public interface UserDao {
    int insertUser(User user);//插入一个实体
    int deleteById(Integer id);//根据id删除一个实体
    int updateUser(User user);//更新一个实体
    List<User> getAllUser();//获取所有实体
    User getUserById(Integer id);//根据id获取一个实体
    List<User> getUserLike(String keywords);//根据关键字实现模糊查询
}
