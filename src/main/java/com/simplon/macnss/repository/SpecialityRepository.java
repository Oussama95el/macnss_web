package com.simplon.macnss.repository;

import com.simplon.macnss.model.refundable.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialityRepository extends JpaRepository<Speciality, Long> {

    Speciality findByTotal(Float total);


}
