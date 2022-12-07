package com.simplon.macnss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AgentController {



    @GetMapping("/agent/dashboard")
    public String index() {
        return "dashboard";
    }
}
