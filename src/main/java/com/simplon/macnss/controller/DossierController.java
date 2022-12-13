package com.simplon.macnss.controller;


import com.simplon.macnss.model.dossier.Dossier;
import com.simplon.macnss.model.person.Patient;
import com.simplon.macnss.model.refundable.Analysis;
import com.simplon.macnss.model.refundable.Medication;
import com.simplon.macnss.model.refundable.Radio;
import com.simplon.macnss.model.refundable.Speciality;
import com.simplon.macnss.service.DossierServiceImpl;
import com.simplon.macnss.service.MedicationServiceImpl;
import com.simplon.macnss.service.PatientServiceImpl;
import com.simplon.macnss.service.SpecialityServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@Controller
public class DossierController {

    @Autowired
    private SpecialityServiceImpl specialityService;
    @Autowired
    private DossierServiceImpl dossierServiceImpl;
    @Autowired
    private MedicationServiceImpl medicationServiceImpl;
    @Autowired
    private PatientServiceImpl patientServiceImpl;

    @GetMapping("/dossiers")
    public String index(Model model) {
        model.addAttribute("dossier", dossierServiceImpl.findAll());
        return "dossier";
    }

    @GetMapping("/dossier/{id}")
    public String show(@PathVariable Long id, Model model) {
        model.addAttribute("dossier", dossierServiceImpl.findById(id));
        return "dossier";
    }

    @GetMapping("/dossier/new")
    public String newDocument(Model model) {
        model.addAttribute("dossier", new Dossier());
        return "dossierForm";
    }

    @PostMapping("/dossier/new")
    public String saveDocument(Model model, HttpServletRequest request) {
        int medic_number = Integer.parseInt(request.getParameter("medic_number"));
        int docs_number = Integer.parseInt(request.getParameter("docs_number"));
        Patient patient = patientServiceImpl.findPatientByPatientNumber(Long.parseLong(request.getParameter("patientId")));
        Dossier dossier = new Dossier();
        dossier.setPatientId(patient.getId());
        dossier.setPatient(patient);
        // save dossier
        String specialityVal = request.getParameter("consType");
        List<Speciality> specialities = specialityService.findAll();
        if (specialityVal.equals("80")) {
            // stream and remove all specialities with total != 80
            specialities.removeIf(speciality -> speciality.getTotal() != 80);
            // set speciality to dossier
            dossier.setSpecialities(specialities);
        }else {
            // stream and remove all specialities with total != 100
            specialities.removeIf(speciality -> speciality.getTotal() != Float.parseFloat(specialityVal));
            // set speciality to dossier
            dossier.setSpecialities(specialities);
        }

        // check if medic_number > 0  and save each medication
        if (medic_number > 0) {
            //find all medications to list
            List<Medication> medications = medicationServiceImpl.findAll();
            for (int i = 1; i < medic_number+1; i++) {
                try {
                    long codeBarre = Long.parseLong(request.getParameter("medic" + i));
                    Medication medication = medicationServiceImpl.findMedicationByCodeBarre(codeBarre);
                    // stream and remove all medications with codeBarre != codeBarre
                    medications.removeIf(medication1 -> !Objects.equals(medication1.getCodeBarre(), medication.getCodeBarre()));
                    System.out.println(medications);
                } catch (Exception e) {
                    System.out.println("medication not found");
                }
            }
            dossier.setMedications(medications);
        }
        // set documents
        if (docs_number > 1) {
            for (int i = 0; i < docs_number; i++) {
                try {
                    String docType = request.getParameter("docType" + i+1);
                    switch (docType){
                        case "ANALYSE":
                            Analysis analysis = new Analysis();
                            analysis.setName("ANALYSE");
                            analysis.setTotal(Float.parseFloat(request.getParameter("docPrice" + i+1)));
                            dossier.getAnalyses().add(analysis);
                            break;
                        case "RADIO":
                            Radio radio = new Radio();
                            radio.setName("RADIO");
                            radio.setTotal(Float.parseFloat(request.getParameter("docPrice" + i)));
                            dossier.getRadios().add(radio);
                    }

                } catch (Exception e) {
                    System.out.println("document not found");
                }
            }
        }else {
            String docType = request.getParameter("docType");
            String docPrice = request.getParameter("docPrice");
            if (docPrice == null) {
                dossierServiceImpl.save(dossier);
                return "redirect:/dossiers";
            }else {
                switch (docType){
                    case "ANALYSE":
                        Analysis analysis = new Analysis();
                        analysis.setName("ANALYSE");
                        analysis.setTotal(Float.parseFloat(docPrice));
                        // new list of analysis and add analysis to it
                        List<Analysis> analyses = dossier.getAnalyses();
                        analyses.add(analysis);
                        dossier.setAnalyses(analyses);
                        break;
                    case "RADIO":
                        Radio radio = new Radio();
                        radio.setName("RADIO");
                        radio.setTotal(Float.parseFloat(docPrice));
                        // new list of radio and add radio to it
                        List<Radio> radios = dossier.getRadios();
                        radios.add(radio);
                        dossier.setRadios(radios);
                }
            }
        }
            dossierServiceImpl.save(dossier);

        return "redirect:/dossier";
    }

    @GetMapping("/dossier/{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("dossier", dossierServiceImpl.findById(id));
        return "dossierForm";
    }

    @GetMapping("/dossier/{id}/delete")
    public String delete(@PathVariable Long id) {
        dossierServiceImpl.deleteById(id);
        return "redirect:/dossier";
    }


}
