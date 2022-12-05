package com.simplon.macnss.controller;

import com.simplon.macnss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

//    @Autowired
//    private UserService userService;


    @GetMapping("/login")
    public String index() { return "/views/login"; }


    @PostMapping("/login/auth")
    public String validateLogin() {
//        TODO : after create login form and service fill this method to validate login if true redirect to user dashboard else redirect to login page
        return "redirect:/";
    }


}
