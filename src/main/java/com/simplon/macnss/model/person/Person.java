package com.simplon.macnss.model.person;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

@MappedSuperclass
public class Person {

    private Class<? extends Person> type;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @org.springframework.data.annotation.Transient
    private String userType;

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Person(){}

    public Person(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public Person(long id, String email, String username, String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Class<? extends Person> getType() {
        return type;
    }

    public void setType(Class<? extends Person> type) {
        this.type = type;
    }
}
