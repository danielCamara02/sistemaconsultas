package com.appointmentsystem.appointmentsystem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointmentsystem.appointmentsystem.models.Patient;
import com.appointmentsystem.appointmentsystem.repositories.PatientRepository;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return null;
    }

    public Patient createPatient(Patient patient) {
        return null;
    }

    public Patient updatePatient(Long id, Patient patient) {
        return null;
    }

    public boolean deletePatient(Long id) {
        return false;
    }

    public Patient login(String email, String password) {
        return null;
    }
}
