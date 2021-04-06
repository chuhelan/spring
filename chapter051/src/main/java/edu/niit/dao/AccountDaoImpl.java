package edu.niit.dao;

import edu.niit.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author： HP
 * @date： 2021-4-1
 * @description： AccountDaoImpl
 */
@Repository
public class AccountDaoImpl implements AccountDao{
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Account getAccountById(Integer id) {
        String sql = "SELECT * FROM t_account WHERE id=?";
        return jdbcTemplate.queryForObject(sql,
                new BeanPropertyRowMapper<>(Account.class),id);
    }

    @Override
    public Boolean transfer(Integer outId, Integer inId, double money) {
        /*转出*/
        String sql = "UPDATE t_account SET balance=balance - ? WHERE id=?";
        Object[] args = {money, outId};
        int n1=jdbcTemplate.update(sql, args);
        /*添加异常*/
        int i=10/0;
        String sql1 = "UPDATE t_account SET balance=balance + ? WHERE id=?";
        Object[] args1 = {money, inId};
        int n2=jdbcTemplate.update(sql1, args1);

        if(n1==1 && n2==1){
            return true;
        }else
            return false;


    }
}
