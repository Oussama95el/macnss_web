package com.simplon.macnss.repository;

import com.simplon.macnss.model.person.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    Patient findPatientByEmail(String email);
    Patient findPatientByPatientNumber(long patientNumber);





}
