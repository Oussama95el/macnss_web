package com.simplon.macnss.service;

import com.simplon.macnss.model.refundable.Medication;
import com.simplon.macnss.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationServiceImpl {

    @Autowired
    private MedicationRepository medicationRepository;


    // function to find medication by code barre
    public Medication findMedicationByCodeBarre(long codeBarre) {
        return medicationRepository.findMedicationByCodeBarre(codeBarre);
    }

    public List<Medication> findAll() {
        return medicationRepository.findAll();
    }
}
