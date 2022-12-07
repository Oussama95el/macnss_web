package com.simplon.macnss.repository;

import com.simplon.macnss.model.dossier.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierRespository extends JpaRepository<Dossier, Long> {
}

