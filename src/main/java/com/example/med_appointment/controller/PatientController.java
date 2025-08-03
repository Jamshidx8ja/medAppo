package com.example.med_appointment.controller;

import com.example.med_appointment.dto.request.PatientRequest;
import com.example.med_appointment.filter.PatientFilter;
import com.example.med_appointment.service.PatientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("patient")
@RequiredArgsConstructor
public class PatientController {
    private final PatientService service;

    @GetMapping("list")
    public ResponseEntity<?> getAllPatients(PatientFilter filter) {
        return ResponseEntity.ok(service.getPatientsList(filter));
    }

    @GetMapping("by-patientId/{patientId}")
    public ResponseEntity<?> getPatientById(@PathVariable Integer patientId) {
        return ResponseEntity.ok(service.getPatientById(patientId));
    }

    @PostMapping("create")
    public ResponseEntity<?> createPatient(@RequestBody PatientRequest patientRequest) {
        return ResponseEntity.ok(service.createPatient(patientRequest));
    }

    @PutMapping("update/{patiendId}")
    public ResponseEntity<?> updatePatient(@PathVariable Integer patientId, @RequestBody PatientRequest request) {
        return ResponseEntity.ok(service.updatePatient(request,  patientId));
    }

    @DeleteMapping("delete/{patientId}")
    public ResponseEntity<?> deletePatient(@PathVariable Integer patientId) {
        return ResponseEntity.ok(service.deletePatient(patientId));
    }
}
