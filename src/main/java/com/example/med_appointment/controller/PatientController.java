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
    private final PatientService patientService;

    @GetMapping("list")
    public ResponseEntity<?> getAllPatients(PatientFilter filter) {
        return ResponseEntity.ok(patientService.getPatientsList(filter));
    }

    @GetMapping("by-patientId/{patientId}")
    public ResponseEntity<?> getPatientById(@PathVariable Integer patientId) {
        return ResponseEntity.ok(patientService.getPatientById(patientId));
    }

    @PostMapping("create")
    public ResponseEntity<?> createPatient(@RequestBody PatientRequest patientRequest) {
        return ResponseEntity.ok(patientService.createPatient(patientRequest));
    }

    @PutMapping("update/{patientId}")
    public ResponseEntity<?> updatePatient(@PathVariable Integer patientId, @RequestBody PatientRequest request) {
        return ResponseEntity.ok(patientService.updatePatient(request,  patientId));
    }

    @DeleteMapping("delete/{patientId}")
    public ResponseEntity<?> deletePatient(@PathVariable Integer patientId) {
        return ResponseEntity.ok(patientService.deletePatient(patientId));
    }
}
