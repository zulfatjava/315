package com.example.kata312.service;



import com.example.kata312.model.Role;
import com.example.kata312.model.User;

import java.util.List;

public interface UserService {
    User getById(Integer id);

    List<User> listUsers();

    void removeUser(Integer id);

    void updateUser(User user);

    boolean add(User user);
    User findByEmail(String email);

    List<Role> listByRole(List<String> lsr);
}
