package com.itsabootstrap.controllers;

import com.itsabootstrap.model.User;
import com.itsabootstrap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserControllers {

    @Autowired
    private UserService userService;


    @GetMapping(value = "")
    public String singleUser(Model model) {
        User user = userService.loadUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        model.addAttribute("user", user);
        return "/user/user";
    }

    @GetMapping(value = "/denied")
    public String deniedAccess() {
        return "user/denied";
    }
}
