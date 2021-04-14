package com.chuhelan.dao;

import com.chuhelan.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDaoAnno {

    @Select("select * from t_user")
    List<User> findAll();

    @Insert("insert into t_user values(null,#{username},#{birthday},#{sex},#{address})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertUser(User user);

    @Update("update t_user set username=#{username} ,birthday=#{birthday},sex=#{sex},address=#{address} where id=#{id}")
    int updateUser(User user);

    @Delete(" delete from t_user where id = #{id}")
    int deleteUserById(Integer id);

    @Select("select * from t_user where id = #{id}")
    User findUserById(Integer id);

    @Select("select * from t_user where id=#{id} and username=#{username}")
    User findByCondition(@Param("id") Integer id, @Param("username") String username);

}
