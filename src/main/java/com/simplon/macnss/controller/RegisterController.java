package com.simplon.macnss.controller;

import com.simplon.macnss.model.User;
import com.simplon.macnss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String index() {
        System.out.println("register");
        return "register";
    }

    @PostMapping("/register")
    public String register(@Validated  @ModelAttribute User user, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
//        userService.save(user);
        return "redirect:/";
    }
}