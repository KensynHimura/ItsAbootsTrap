package com.itsabootstrap.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GuestControllers {

    @GetMapping("/")
    public String greetings(ModelMap model) {
        model.addAttribute("greeting", ", glad to see you!");
        return "greeting";
    }
//
//    @GetMapping(value = "/test")
//    public String printWelcome(ModelMap model) {
//        return "test";
//    }
}
