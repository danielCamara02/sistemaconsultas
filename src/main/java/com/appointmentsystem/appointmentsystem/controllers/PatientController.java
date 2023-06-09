package com.appointmentsystem.appointmentsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.appointmentsystem.appointmentsystem.dto.LoginRequest;
import com.appointmentsystem.appointmentsystem.models.Appointment;
import com.appointmentsystem.appointmentsystem.models.Patient;
import com.appointmentsystem.appointmentsystem.services.PatientService;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patients = patientService.getAllPatients();
        return new ResponseEntity<>(patients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id) {
        Patient patient = patientService.getPatientById(id);
        if (patient != null) {
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        Patient updatedPatient = patientService.updatePatient(id, patient);
        if (updatedPatient != null) {
            return new ResponseEntity<>(updatedPatient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Patient> login(@RequestBody LoginRequest loginRequest) {
        Patient patient = patientService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (patient != null) {
            return new ResponseEntity<>(patient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

   @GetMapping("/{patientId}/appointments")
    public ResponseEntity<List<Appointment>> viewAppointments(@PathVariable Long patientId) {
        Patient patient = patientService.getPatientById(patientId);
        if (patient == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<Appointment> appointments = patientService.getAppointmentsByPatient(patient);
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }
}

