package com.simplon.macnss.service;

import com.simplon.macnss.model.dossier.Dossier;
import com.simplon.macnss.repository.DossierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DossierServiceImpl {

    @Autowired
    private DossierRepository dossierRepository;


    public Dossier save(Dossier dossier) {
        return dossierRepository.save(dossier);
    }

    public Dossier findById(Long id) {
        return dossierRepository.findById(id).get();
    }

    public Iterable<Dossier> findAll() {
        return dossierRepository.findAll();
    }

    public void deleteById(Long id) {
        dossierRepository.deleteById(id);
    }

}
