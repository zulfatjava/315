package com.example.kata312.controller;



import com.example.kata312.model.User;
import com.example.kata312.service.UserDetailsServiceImp;
import com.example.kata312.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserDetailsServiceImp userDetailsServiceImp;
    private final UserService userService;

    @Autowired
    public AdminController(UserDetailsServiceImp userDetailsServiceImp,UserService userService) {
        this.userService = userService;
        this.userDetailsServiceImp = userDetailsServiceImp;
    }

    @GetMapping("")
    public ModelAndView admin(Principal user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin/admin");
        List<User> users = userService.listUsers();
        modelAndView.addObject("users", users);
        //modelAndView.addObject("admin", userService.findByEmail(user.getName()));
        return modelAndView;
    }

    @PostMapping("/add")
    public String addUser(User user) {
        userService.add(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id, Model model) {
        userService.removeUser(id);
        return "redirect:/admin";
    }

    @PutMapping("/user-update/{id}")
    public String editUser(@PathVariable("id") int id, User user) {
        user.setId(id);
        userService.updateUser(user);
        return "redirect:/admin";
    }
}

