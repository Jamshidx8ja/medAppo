package com.example.med_appointment.controller;

import com.example.med_appointment.dto.request.DoctorRequest;
import com.example.med_appointment.dto.response.DoctorResponse;
import com.example.med_appointment.filter.DoctorFilter;
import com.example.med_appointment.service.DoctorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/doctor")
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorService service;

    @GetMapping("list")
    public ResponseEntity<?> getDoctorList(DoctorFilter filter) {
        return ResponseEntity.ok(service.getDoctorsList(filter));
    }

    @GetMapping("by-id/{doctorId}")
    public ResponseEntity<?> getDoctorById(@PathVariable Integer doctorId) {
        return ResponseEntity.ok(service.getDoctorById(doctorId));
    }

    @PostMapping("create")
    public ResponseEntity<?> createDoctor(@RequestBody DoctorRequest doctorRequest) {
        return ResponseEntity.ok(service.createDoctor(doctorRequest));
    }

    @PutMapping("update/{doctorId}")
    public ResponseEntity<?>  updateDoctor(@PathVariable Integer doctorId, @RequestBody DoctorRequest request) {
        return ResponseEntity.ok(service.updateDoctor(request, doctorId));
    }

    @DeleteMapping("delete/{doctorId}")
    public ResponseEntity<?> deleteDoctor(@PathVariable Integer doctorId) {
        return ResponseEntity.ok(service.deleteDoctor(doctorId));
    }

}
