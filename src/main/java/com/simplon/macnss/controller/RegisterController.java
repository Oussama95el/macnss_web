package com.simplon.macnss.controller;

import com.simplon.macnss.model.person.Agent;
import com.simplon.macnss.model.person.Patient;
import com.simplon.macnss.model.person.Person;
import com.simplon.macnss.repository.DossierRepository;
import com.simplon.macnss.service.AgentServiceImpl;
import com.simplon.macnss.service.PatientServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

    private final
    AgentServiceImpl agentServiceImpl;
    private final
    DossierRepository dossierRepository;

    private final PatientServiceImpl patientServiceImpl;

    public RegisterController(DossierRepository dossierRepository, AgentServiceImpl agentServiceImpl, PatientServiceImpl patientServiceImpl) {
        this.dossierRepository = dossierRepository;
        this.agentServiceImpl = agentServiceImpl;
        this.patientServiceImpl = patientServiceImpl;
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

    @PostMapping("/register/patient")
    public String register(@Validated @ModelAttribute Patient patient, BindingResult result) {
        if (result.hasErrors()) {
            return "register";
        }
        // generate random patientNumber and check if it's unique
        Long patientNumber = patientServiceImpl.generatePatientNumber();
        patient.setPatientNumber(patientNumber);
        patientServiceImpl.save(patient);
        return "redirect:/";
    }
}
