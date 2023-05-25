package com.example.kata312.controller;

import com.example.kata312.dao.UserDao;
import com.example.kata312.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping
    public String printWelcome(ModelMap model, Principal principal) {
        User user = userDao.findByEmail(principal.getName());
        model.addAttribute("roles", user.getRoles());
        model.addAttribute("user", user);
        return "users/user";
    }



}


