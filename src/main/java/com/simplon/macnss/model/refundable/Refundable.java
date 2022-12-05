package com.simplon.macnss.model.refundable;

import jakarta.persistence.*;

@MappedSuperclass
public class Refundable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private Float total;

    public Refundable() {
    }

    public Refundable(String name, Float repayment) {
        this.name = name;
        this.total = repayment;
    }

    public Refundable(long id, String name, Float repayment) {
        this.id = id;
        this.name = name;
        this.total = repayment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float repayment) {
        this.total = repayment;
    }
}
