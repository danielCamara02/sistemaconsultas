package com.appointmentsystem.appointmentsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appointmentsystem.appointmentsystem.models.Appointment;
import com.appointmentsystem.appointmentsystem.models.Doctor;

@Service
public class DoctorService {
    public List<Doctor> getAllDoctors() {
        return null;
    }

    public Doctor getDoctorById(Long id) {
        return null;
    }

    public Doctor createDoctor(Doctor doctor) {
        return null;
    }

    public Doctor updateDoctor(Long id, Doctor doctor) {
        return null;
    }

    public boolean deleteDoctor(Long id) {
        return false;
    }

    public Doctor login(String email, String password) {
        return null;
    }

    public Appointment createAppointment(Appointment appointment) {
        return null;
    }

    public Appointment updateAppointment(Long appointmentId, Appointment appointment) {
        return null;
    }

    public boolean deleteAppointment(Long appointmentId) {
        return false;
    }

    public List<Appointment> getAppointmentsByDoctor(Doctor doctor) {
        return null;
    }
}
