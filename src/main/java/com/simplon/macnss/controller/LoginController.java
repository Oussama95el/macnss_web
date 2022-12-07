package com.simplon.macnss.controller;

import com.simplon.macnss.model.person.Agent;
import com.simplon.macnss.model.person.Patient;
import com.simplon.macnss.model.person.Person;
import com.simplon.macnss.service.AgentServiceImpl;
import com.simplon.macnss.service.PatientServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    private final AgentServiceImpl agentServiceImpl;
    private final PatientServiceImpl patientServiceImpl;
    public LoginController(AgentServiceImpl agentServiceImpl, PatientServiceImpl patientServiceImpl) {
        this.agentServiceImpl = agentServiceImpl;
        this.patientServiceImpl = patientServiceImpl;
    }

    @RequestMapping("/login")
    public String loginAgent(@NotNull HttpServletRequest request) {
        System.out.println(request.getContextPath());
        return "login";
    }


    @PostMapping("/login/user")
    public String validateLogin(@Validated @ModelAttribute Person person, BindingResult result) {
        if (result.hasErrors()) {
            return "login";
        }
        System.out.println(person.getUserType());
        // check person type
        if (person.getUserType().equals("agent")) {
            Agent agent = new Agent();
            agent.setEmail(person.getEmail());
            agent.setPassword(person.getPassword());
            if (agentServiceImpl.checkAgentEmail(agent)) {
                if (agentServiceImpl.checkAgentPassword(agent)) {
                    System.out.println("agent login success");
                    return "redirect:/agent/dashboard";
                }else {
                    System.out.println("agent login failed");
                    return "redirect:/login";
                }
                }
            } else if (person.getUserType().equals("patient")) {
                Patient patient = new Patient();
                patient.setEmail(person.getEmail());
                patient.setPassword(person.getPassword());
                if (patientServiceImpl.checkPatientEmail(patient.getEmail())) {
                    if (patientServiceImpl.checkPatientPassword(patient)) {
                        System.out.println("patient login success");
                        return "redirect:/patient/dashboard";
                    }else {
                        System.out.println("patient login failed");
                        return "redirect:/login";
                    }
                }
            }

        return "login";

}}
