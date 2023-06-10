package com.appointmentsystem.appointmentsystem.models;

import java.util.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "Appointment")
public class Appointment {
    @Id
    @Column(name = "appointment_id")
    private long id;

    @Column(name = "appointment_date", nullable = false)
    private Date appointmentDate;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @Column(name = "diagnosis")
    private String diagnosis;

    @Column(name = "prescription")
    private String prescription;

    // Default constructor
    public Appointment() {
    }

    // Constructor with all attributes
    public Appointment(long id, Date appointmentDate, Doctor doctor, Patient patient, String diagnosis, String prescription) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
        this.patient = patient;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
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

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    // Constructors, getters, and setters
    // ...

    
}

