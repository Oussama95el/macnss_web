package com.simplon.macnss.controller;

import com.simplon.macnss.model.person.Agent;
import com.simplon.macnss.model.person.Person;
import com.simplon.macnss.repository.DossierRespository;
import com.simplon.macnss.security.HashWithSalt;
import com.simplon.macnss.service.AgentServiceImpl;
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

    private final AgentServiceImpl agentServiceImpl;
    final
    DossierRespository dossierRespository;

    public RegisterController(DossierRespository dossierRespository , AgentServiceImpl agentServiceImpl) {
        this.dossierRespository = dossierRespository;
        this.agentServiceImpl = agentServiceImpl;
    }

    @GetMapping("/register")
    public String index() {
        return "register";
    }

    @PostMapping("/register/agent")
    public String register(@Validated @ModelAttribute Agent agent, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        agentServiceImpl.save(agent);
        return "redirect:/";
    }
}
