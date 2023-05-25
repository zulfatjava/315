package com.example.kata312.dao;

import com.example.kata312.model.Role;

import java.util.List;

public interface RoleDao {
    boolean add(Role role);

    Role findByName(String name);

    List<Role> listByName(List<String> name);



}
