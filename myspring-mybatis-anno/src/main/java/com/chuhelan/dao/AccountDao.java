package com.chuhelan.dao;

import com.chuhelan.domain.Account;
import org.apache.ibatis.annotations.Param;

import javax.annotation.security.PermitAll;

/**
 * @description:
 * @author: chuhelan
 * @create: 2021-04-27 08:41
 **/

public interface AccountDao {
    // 插入账号信息

    int insertAccount();

    // 存款

    int depositById(@Param("money") Double money, @Param("id") Integer id);

    // 取款

    int withdrawById(@Param("money") Double money, @Param("id") Integer id);

    // 根据id查询信息

    Account findById(Integer id);
}
