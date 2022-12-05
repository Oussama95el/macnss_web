package com.simplon.macnss.model.refundable;

import com.simplon.macnss.model.dossier.Dossier;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Medication extends Refundable {
    @ManyToMany(mappedBy = "medications")
    private List<Dossier> dossiers;
}
