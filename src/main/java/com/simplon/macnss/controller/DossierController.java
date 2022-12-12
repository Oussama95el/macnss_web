package com.simplon.macnss.controller;


import com.simplon.macnss.model.dossier.Dossier;
import com.simplon.macnss.service.DossierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
public class DossierController {


    @Autowired
    private DossierServiceImpl dossierServiceImpl;

    @GetMapping("/dossiers")
    public String index(Model model) {
        model.addAttribute("dossier", dossierServiceImpl.findAll());
        return "dossier";
    }

    @GetMapping("/dossier/{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("document", dossierServiceImpl.findById(id));
        return "document";
    }

    @GetMapping("/dossier/new")
    public String newDocument(Model model) {
        model.addAttribute("document", new Dossier());
        return "documentForm";
    }

    @PostMapping("/dossier")
    public String saveDocument(@Validated @ModelAttribute Dossier document, BindingResult result) {
        if (result.hasErrors()) {
            return "documentForm";
        }
        dossierServiceImpl.save(document);
        return "redirect:/dossier";
    }

    @GetMapping("/dossier/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("document", dossierServiceImpl.findById(id));
        return "documentForm";
    }

    @GetMapping("/dossier/{id}/delete")
    public String delete(@PathVariable Long id) {
        dossierServiceImpl.deleteById(id);
        return "redirect:/dossier";
    }

}
