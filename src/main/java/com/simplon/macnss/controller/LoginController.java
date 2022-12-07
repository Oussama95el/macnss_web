package com.simplon.macnss.controller;

import com.simplon.macnss.model.person.Agent;
import com.simplon.macnss.service.AgentServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private AgentServiceImpl agentServiceImpl;

    @RequestMapping("/agent/login")
    public String loginAgent(HttpServletRequest request) {
        System.out.println(request.getContextPath());
        return "login"; }

    @GetMapping("/login/patient")
    public String loginPatient() { return "login"; }


    @PostMapping("/login/agent")
    public String validateLogin(@Validated @ModelAttribute Agent agent, BindingResult result) {
        if (result.hasErrors()) {
            return "login";
        }
        if (agentServiceImpl.checkAgentEmail(agent)){
            if (agentServiceImpl.checkAgentPassword(agent)){
                return "redirect:/";
            }else {
                return "login";
            }
        }else {
            System.out.println("email not found");
            return "login";
        }
    }


}
