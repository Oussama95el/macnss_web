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

    public Patient checkPatientEmail(String email) {
        return patientRepository.findPatientByEmail(email);
    }

    public boolean checkPatientPassword(Patient formPatient) {
        if (formPatient != null) {
            Patient patient = patientRepository.findPatientByEmail(formPatient.getEmail());
            return HashWithSalt.checkPassword(formPatient.getPassword(), patient.getPassword());
        }
        return false;
    }


    public Long generatePatientNumber() {
        long patientNumber = (long) (Math.random() * 1000000000);
        while (patientRepository.findPatientByPatientNumber(patientNumber) != null) {
            patientNumber = (long) (Math.random() * 1000000000);
        }
        return patientNumber;
    }
}

