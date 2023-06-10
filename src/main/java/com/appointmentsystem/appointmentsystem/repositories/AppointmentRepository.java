package com.appointmentsystem.appointmentsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointmentsystem.appointmentsystem.models.Appointment;

public interface AppointmentRepository extends JpaRepository <Appointment,Long>{
    
}
