package com.simplon.macnss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Scontroller {


    @RequestMapping("hello")
    public String index() {
        return "hello";
    }
}