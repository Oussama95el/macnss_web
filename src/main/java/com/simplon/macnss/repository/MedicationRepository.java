package com.simplon.macnss.repository;

import com.simplon.macnss.model.refundable.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface MedicationRepository  extends JpaRepository<Medication, Long> {
    Medication findMedicationByCodeBarre(long codeBarre);
}

