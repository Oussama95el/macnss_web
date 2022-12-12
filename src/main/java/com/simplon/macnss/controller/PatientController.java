package com.simplon.macnss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PatientController {


    @GetMapping("/agent/patient")
    public String patient() {
        return "clients";
    }
}
