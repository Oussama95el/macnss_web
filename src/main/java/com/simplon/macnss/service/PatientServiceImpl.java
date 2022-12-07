package com.simplon.macnss.service;

import com.simplon.macnss.model.person.Patient;
import com.simplon.macnss.model.person.Patient;
import com.simplon.macnss.repository.PatientRepository;
import com.simplon.macnss.security.HashWithSalt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl {

    @Autowired
    private PatientRepository patientRepository;


    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient findPatientByEmail(String email) {
        return patientRepository.findPatientByEmail(email);
    }

    public Patient findPatientByPatientNumber(long patientNumber) {
        return patientRepository.findPatientByPatientNumber(patientNumber);
    }

    public boolean checkPatientEmail(String email) {
        return patientRepository.findPatientByEmail(email) != null;
    }

    public boolean checkPatientPassword(Patient formPatient) {
        Patient patient = patientRepository.findPatientByEmail(formPatient.getEmail());
        return HashWithSalt.checkPassword(formPatient.getPassword(), patient.getPassword());
    }


}

