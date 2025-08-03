package com.example.med_appointment.controller;

import com.example.med_appointment.dto.request.AppointmentRequest;
import com.example.med_appointment.dto.response.AppointmentResponse;
import com.example.med_appointment.filter.AppointmentFilter;
import com.example.med_appointment.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService service;

    @GetMapping("list")
    public ResponseEntity<?> getAllAppointments(AppointmentFilter filter) {
        return ResponseEntity.ok(service.getAppointmentsList(filter));
    }

    @GetMapping("by-patientId/{patientId}")
    public ResponseEntity<?> getAppointmentsByPatientId(@PathVariable Integer appointmentId) {
        return ResponseEntity.ok(service.getAppointmentsByPatientId(appointmentId));
    }

    @GetMapping("by-appointmentId/{appointmentId}")
    public ResponseEntity<?> getAppointmentById(@PathVariable Integer appointmentId) {
        return ResponseEntity.ok(service.getAppointmentById(appointmentId));
    }

    @GetMapping("available-slots")
    public ResponseEntity<?> getAvailableSlots(AppointmentFilter filter) {
        return ResponseEntity.ok(service.getAvailableSlots(filter));
    }


    @PostMapping("book")
    public ResponseEntity<?> bookAppointment(@RequestBody AppointmentRequest request) {
        return ResponseEntity.ok(service.bookAppointment(request));
    }

    @PutMapping("update/{appointmentId}")
    public ResponseEntity<?> updateAppointment(@PathVariable Integer appointmentId, @RequestBody AppointmentRequest request) {
        return ResponseEntity.ok(service.updateAppointment(request,appointmentId));
    }

    @DeleteMapping("cancel/{appointmentId}")
    public ResponseEntity<?> cancelAppointment(@PathVariable Integer appointmentId) {
        return ResponseEntity.ok(service.cancelAppointment(appointmentId));
    }
}
