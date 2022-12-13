package com.simplon.macnss.repository;

import com.simplon.macnss.model.refundable.Analysis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnalyseRepository extends JpaRepository<Analysis, Long> {



}
