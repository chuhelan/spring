package com.chuhelan.dao;

import com.chuhelan.domain.Role;

import java.util.List;

public interface RoleDao {
    List<Role> findAllRoles();

    Role findRoleById(Integer id);

    List<Role> findRoleByUserId(Integer userId);
}
