package com.simplon.macnss.service;

import com.simplon.macnss.model.refundable.Speciality;
import com.simplon.macnss.repository.SpecialityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecialityServiceImpl {

    private final SpecialityRepository specialityRepository;

    public SpecialityServiceImpl(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    // find by total method
    public Speciality findByTotal(Float total) {
        return specialityRepository.findByTotal(total);
    }


    public List<Speciality> findAll() {
        return specialityRepository.findAll();
    }
}
