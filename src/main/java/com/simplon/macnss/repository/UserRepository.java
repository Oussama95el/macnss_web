package com.simplon.macnss.repository;

import com.simplon.macnss.model.person.Person;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository {
    @Transactional
    Person save(Person user);

    @Transactional
    Person update(Person person);

    Person findById(Long id);

    Person findByEmail(String email);

    Person delete(Person person);
}
