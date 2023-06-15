package com.appointmentsystem.appointmentsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.appointmentsystem.appointmentsystem.dto.LoginRequest;
import com.appointmentsystem.appointmentsystem.models.Appointment;
import com.appointmentsystem.appointmentsystem.models.Doctor;
import com.appointmentsystem.appointmentsystem.services.DoctorService;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        Doctor doctor = doctorService.getDoctorById(id);
        if (doctor != null) {
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        Doctor updateDoctor = doctorService.updateDoctor(id, doctor);
        if (updateDoctor != null) {
            return new ResponseEntity<>(updateDoctor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Doctor> login(@RequestBody LoginRequest loginRequest) {
        Doctor doctor = doctorService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (doctor != null) {
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    } 

    @PostMapping("/{doctorId}/appointments")
    public ResponseEntity<Appointment> createAppointment(@PathVariable Long doctorId, @RequestBody Appointment appointment) {
        Doctor doctor = doctorService.getDoctorById(doctorId);
        if (doctor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        appointment.setDoctor(doctor);
        Appointment createdAppointment = doctorService.createAppointment(appointment);
        return new ResponseEntity<>(createdAppointment, HttpStatus.CREATED);
    }

     @PutMapping("/{doctorId}/appointments/{appointmentId}")
    public ResponseEntity<Appointment> updateAppointment(@PathVariable Long appointmentId, @RequestBody Appointment appointment) {
        Appointment updatedAppointment = doctorService.updateAppointment(appointmentId, appointment);
        if (updatedAppointment != null) {
            return new ResponseEntity<>(updatedAppointment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{doctorId}/appointments/{appointmentId}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long appointmentId) {
        boolean deleted = doctorService.deleteAppointment(appointmentId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{doctorId}/appointments")
    public ResponseEntity<List<Appointment>> viewAppointments(@PathVariable Long doctorId) {
        Doctor doctor = doctorService.getDoctorById(doctorId);
        if (doctor == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Appointment> appointments = doctorService.getAppointmentsByDoctor(doctor);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }
}

