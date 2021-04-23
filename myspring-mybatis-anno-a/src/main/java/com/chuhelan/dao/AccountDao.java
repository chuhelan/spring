package com.chuhelan.dao;

import com.chuhelan.domain.Account;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AccountDao {
    @Select("select * from t_account")
    List<Account> findAll();

    @Update("update t_account set balance=balance+ #{money} where id=#{id}")
    int addMoney(@Param("id") Integer id, @Param("money") Double money);

    @Update("update t_account set balance=balance- #{money} where id=#{id}")
    int subMoney(@Param("id") Integer id, @Param("money") Double money);
}
