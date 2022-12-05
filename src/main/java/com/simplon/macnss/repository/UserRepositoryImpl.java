package com.simplon.macnss.repository;

import com.simplon.macnss.model.person.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Person save(Person person) {
        entityManager.persist(person);
        entityManager.flush();
        return person;
    }

    @Override
    @Transactional
    public Person update(Person person) {
        entityManager.merge(person);
        entityManager.flush();
        return person;
    }

    @Override
    public Person findById(Long id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public Person findByEmail(String email) {
        return entityManager.find(Person.class, email);
    }

    @Override
    @Transactional
    public Person delete(Person person) {
        entityManager.remove(person);
        entityManager.flush();
        return person;
    }
}
