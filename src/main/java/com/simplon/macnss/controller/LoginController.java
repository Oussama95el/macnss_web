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
import org.springframework.web.context.annotation.SessionScope;

@Controller
@SessionScope
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
    public String validateLogin(@Validated @ModelAttribute Person person, BindingResult result , HttpServletRequest request) {
        if (result.hasErrors()) {
            return "login";
        }
        // check person type
        if (person.getUserType().equals("agent")) {
            Agent agent = agentServiceImpl.findAgentByEmail(person.getEmail());
            if (agent != null) {
                if (agentServiceImpl.checkAgentPassword(agent, person.getPassword())) {
                    request.getSession().setAttribute("agent", agent);
                    return "redirect:/agent/dashboard";
                } else {
                    System.out.println("agent login failed");
                    return "redirect:/login";
                }
            }
        } else if (person.getUserType().equals("patient")) {
            Patient patient = patientServiceImpl.findPatientByEmail(person.getEmail());
            if (patient != null) {
                if (patientServiceImpl.checkPatientPassword(patient)) {
                    request.getSession().setAttribute("patient", patient);
                    return "redirect:/patient/dashboard";
                } else {
                    System.out.println("patient login failed");
                    return "redirect:/login";
                }
            }
        }
        return "login";
    }


}
