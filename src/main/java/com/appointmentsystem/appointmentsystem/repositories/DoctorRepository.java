package com.appointmentsystem.appointmentsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointmentsystem.appointmentsystem.models.Doctor;

public interface DoctorRepository extends JpaRepository <Doctor,Long> {
    
}
