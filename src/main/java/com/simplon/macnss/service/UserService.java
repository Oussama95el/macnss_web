package com.simplon.macnss.service;

import com.simplon.macnss.model.person.Person;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void save(Person person);

    @Transactional
    void update(Person person);

    Person findById(Long id);

    Person findByEmail(String email);

    @Transactional
    void delete(Person person);
}

