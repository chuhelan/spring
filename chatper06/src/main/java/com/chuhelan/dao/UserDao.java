package com.chuhelan.dao;

import com.chuhelan.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author wmp231316
 */
public interface UserDao {
    List<User> findAll();

    User findUserById(Integer id);

    int updateUser(User user);

    int insertUser(User user);

    int deleteUserById(Integer id);

    User findByMap(Map map);

    User findByCondition(@Param("id") Integer id, @Param("username") String username);

}
