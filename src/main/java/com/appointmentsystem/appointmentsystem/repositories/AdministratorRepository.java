package com.appointmentsystem.appointmentsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointmentsystem.appointmentsystem.models.Administrator;

public interface AdministratorRepository extends JpaRepository <Administrator,Long> {
    
}
