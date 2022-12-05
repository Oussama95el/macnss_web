package com.simplon.macnss.service;

import com.simplon.macnss.model.person.Person;
import com.simplon.macnss.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void save(Person person) {
        userRepository.save(person);
    }

    @Override
    @Transactional
    public void update(Person person) {
        userRepository.update(person);
    }

    @Override
    public Person findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Person findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public void delete(Person person) {
        userRepository.delete(person);
    }

}


