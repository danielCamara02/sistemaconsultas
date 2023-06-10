package com.appointmentsystem.appointmentsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointmentsystem.appointmentsystem.models.Patient;

public interface PatientRepository extends JpaRepository <Patient,Long> {
    
}
