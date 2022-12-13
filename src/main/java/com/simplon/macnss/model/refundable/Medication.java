package com.simplon.macnss.model.refundable;

import com.simplon.macnss.model.dossier.Dossier;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Medication extends Refundable {

    @Column
    private Long codeBarre;

    public Long getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(Long codeBarre) {
        this.codeBarre = codeBarre;
    }

    public List<Dossier> getDossiers() {
        return dossiers;
    }

    public void setDossiers(List<Dossier> dossiers) {
        this.dossiers = dossiers;
    }

    @ManyToMany(mappedBy = "medications")
    private List<Dossier> dossiers;
}
