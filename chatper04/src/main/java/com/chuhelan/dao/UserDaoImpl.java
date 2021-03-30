package com.chuhelan.dao;

import com.chuhelan.domain.User;
import com.chuhelan.mapper.UserRowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


/**
 * @description:
 * @author: chuhelan
 * @create: 2021-03-25 14:13
 **/

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //增加一个日志查看回调的id
    private final Logger logger =
            LoggerFactory.getLogger(UserDaoImpl.class);


//    @Override
//    public int insertUser(User user) {
//        int n = 0;
//        String sql = "insert into t_user(id,account,password) values(null,?,?)";
//        Object[] args = {user.getAccount(), user.getPassword()};
//        n = jdbcTemplate.update(sql, args);
//        return n;
//    }

    @Override
    public int insertUser(User user) {
        int n = 0;
        String sql = "INSERT INTO t_user VALUES(null,?,?)";
        Object[] args = {user.getAccount(), user.getPassword()};
        GeneratedKeyHolder KeyHolder = new GeneratedKeyHolder();
        n = jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
// 如果不是拼接的，参数直接放在sql语句中，则使用下面的语句
// return connection.prepareStatement(sql,args);
                PreparedStatement psmt = connection.prepareStatement(sql, new
                        String[]{"id"});
                psmt.setString(1, (String) args[0]);
                psmt.setString(2, (String) args[1]);
                return psmt;
            }
        }, KeyHolder);
        Integer newId = KeyHolder.getKey().intValue();
        user.setId(newId);
        logger.info("后台存储数据：" + user.toString());
        return n;
    }

    @Override
    public int deleteById(Integer id) {
        int n = 0;
        String sql = "delete from t_user where id=?";
        Object[] args = {id};
        n = jdbcTemplate.update(sql, args);
        return n;
    }

    @Override
    public int updateUser(User user) {
        int n = 0;
        String sql = "update t_user set account=? , password=? where id=?";
        Object[] args = {user.getAccount(), user.getPassword(), user.getId()};
        n = jdbcTemplate.update(sql, args);
        return n;
    }

    public List<User> getAllUser() {
        String sql = "SELECT * from t_user";
// return jdbcTemplate.query(sql, new UserRowMapper());
// 如果列名和属性名都是相同的，也可以直接使用BeanPropertyRowMapper，如果不一样
// 则使用自己定义的UserRowMapper
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>
                (User.class));
    }


    @Override
    public User getUserById(Integer id) {
        String sql = "select * from t_user where id=" + id;
        return jdbcTemplate.queryForObject(sql, new UserRowMapper());
    }


    @Override
    public List<User> getUserLike(String keywords) {
        String sql = "select * from t_user where account like " +
                "'%" + keywords + "%'";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }
}