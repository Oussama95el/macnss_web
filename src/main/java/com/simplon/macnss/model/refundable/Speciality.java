package com.simplon.macnss.model.refundable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Speciality extends Refundable{

    @Column
    private Boolean medicationRefundable;

    public Speciality() {
    }

    public Speciality(String name, Float repayment, Boolean medicationRefundable) {
        super(name, repayment);
        this.medicationRefundable = medicationRefundable;
    }


    public Boolean getMedicationRefundable() {
        return medicationRefundable;
    }

    public void setMedicationRefundable(Boolean medicationRefundable) {
        this.medicationRefundable = medicationRefundable;
    }
}
