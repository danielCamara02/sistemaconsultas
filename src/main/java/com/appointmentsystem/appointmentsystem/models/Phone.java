package com.appointmentsystem.appointmentsystem.models;

import jakarta.persistence.*;

@Entity
@Table(name = "Phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "phone_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    // @Column(name = "phone_number", nullable = false)
    // private String phoneNumber;
    private String phoneNumber;

    // Default constructor
    public Phone() {
    }

    // Constructor with all attributes
    public Phone(long id, Doctor doctor, Patient patient, String phoneNumber) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.phoneNumber = phoneNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
