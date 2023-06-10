package com.appointmentsystem.appointmentsystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Doctor")
public class Doctor {
    @Id
    @Column(name = "doctor_id")
    private Long id;

    @Column(name = "crm", unique = true, nullable = false)
    private String crm;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "specialty", nullable = false)
    private String specialty;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    // Default constructor
    public Doctor() {
    }

    // Constructor with all attributes
    public Doctor(Long id, String crm, String name, String specialty, String address, String password, String email) {
        this.id = id;
        this.crm = crm;
        this.name = name;
        this.specialty = specialty;
        this.address = address;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
