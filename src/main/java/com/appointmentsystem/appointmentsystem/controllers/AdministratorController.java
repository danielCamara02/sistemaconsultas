package com.appointmentsystem.appointmentsystem.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.appointmentsystem.appointmentsystem.models.Administrator;
import com.appointmentsystem.appointmentsystem.models.Doctor;
import com.appointmentsystem.appointmentsystem.models.Patient;
import com.appointmentsystem.appointmentsystem.services.AdministratorService;
import com.appointmentsystem.appointmentsystem.services.DoctorService;
import com.appointmentsystem.appointmentsystem.services.PatientService;

import java.util.List;

@RestController
@RequestMapping("/administrators")
public class AdministratorController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<Administrator>> getAllAdministrators() {
        List<Administrator> administrators = administratorService.getAllAdministrators();
        return new ResponseEntity<>(administrators, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Administrator> getAdministratorById(@PathVariable Long id) {
        Administrator administrator = administratorService.getAdministratorById(id);
        if (administrator == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(administrator, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Administrator> createAdministrator(@RequestBody Administrator administrator) {
        Administrator createdAdministrator = administratorService.createAdministrator(administrator);
        return new ResponseEntity<>(createdAdministrator, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administrator> updateAdministrator(@PathVariable Long id, @RequestBody Administrator administrator) {
        Administrator updatedAdministrator = administratorService.updateAdministrator(id, administrator);
        if (updatedAdministrator == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedAdministrator, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdministrator(@PathVariable Long id) {
        boolean deleted = administratorService.deleteAdministrator(id);
        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody Doctor doctor) {
        Doctor createdDoctor = doctorService.createDoctor(doctor);
        return new ResponseEntity<>(createdDoctor, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        boolean deleted = doctorService.deleteDoctor(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient createdPatient = patientService.createPatient(patient);
        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        boolean deleted = patientService.deletePatient(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

