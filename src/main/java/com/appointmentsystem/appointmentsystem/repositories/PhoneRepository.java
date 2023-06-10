package com.appointmentsystem.appointmentsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointmentsystem.appointmentsystem.models.Phone;

public interface PhoneRepository extends JpaRepository <Phone,Long> {
    
}
