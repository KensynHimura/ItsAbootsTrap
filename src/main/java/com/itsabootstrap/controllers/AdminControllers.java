package com.itsabootstrap.controllers;

import com.itsabootstrap.model.User;
import com.itsabootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminControllers {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @GetMapping(value = "/allusers")
    public String userList(Model model, Principal detail) {
        User user = new User();
        model.addAttribute("person", userService.loadUserByUsername(detail.getName()));
        model.addAttribute("adduser", user);
        List<User> userList = userService.listUsers();
        model.addAttribute("userList", userList);
        return "allusers";
    }

    @PostMapping(value = "/list/save")
    public String saveOrUpdateUser(@ModelAttribute("user") User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userService.saveOrUpdateUser(user);
        return "redirect:/admin/allusers";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/allusers";
    }
}

