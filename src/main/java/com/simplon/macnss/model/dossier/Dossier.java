package com.simplon.macnss.model.dossier;

import com.simplon.macnss.model.person.Patient;
import com.simplon.macnss.model.refundable.Analysis;
import com.simplon.macnss.model.refundable.Medication;
import com.simplon.macnss.model.refundable.Radio;
import com.simplon.macnss.model.refundable.Speciality;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Dossier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "patient_id")
    private Long patientId;

    @ManyToOne
    @JoinColumn(name = "patient_id",insertable = false,updatable = false)
    private Patient patient;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "dossier_medication",
            joinColumns = { @JoinColumn(name = "dossier_id") },
            inverseJoinColumns = { @JoinColumn(name = "medication_id") }
    )
    private List<Medication> medications;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "dossier_analysis",
            joinColumns = {@JoinColumn(name = "dossier_id")},
            inverseJoinColumns = { @JoinColumn(name = "analysis_id") }
    )
    private List<Analysis> analyses;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "dossier_speciality",
            joinColumns = {@JoinColumn(name = "dossier_id")},
            inverseJoinColumns = { @JoinColumn(name = "speciality_id") }
    )
    private List<Speciality> specialities;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "dossier_radio",
            joinColumns = {@JoinColumn(name = "dossier_id")},
            inverseJoinColumns = { @JoinColumn(name = "radio_id") }
    )
    private List<Radio> radios;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    public List<Analysis> getAnalyses() {
        return analyses;
    }

    public void setAnalyses(List<Analysis> analyses) {
        this.analyses = analyses;
    }

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<Speciality> specialities) {
        this.specialities = specialities;
    }

    public List<Radio> getRadios() {
        return radios;
    }

    public void setRadios(List<Radio> radios) {
        this.radios = radios;
    }
}
