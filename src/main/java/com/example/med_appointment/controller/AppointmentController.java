package com.example.med_appointment.controller;

import com.example.med_appointment.dto.request.AppointmentRequest;
import com.example.med_appointment.filter.AppointmentFilter;
import com.example.med_appointment.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("appointment")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;

    @GetMapping("list")
    public ResponseEntity<?> getAllAppointments(AppointmentFilter filter) {
        return ResponseEntity.ok(appointmentService.getAppointmentsList(filter));
    }

    @GetMapping("by-patient/{patientId}")
    public ResponseEntity<?> getAppointmentsByPatientId(@PathVariable Integer patientId) {
        return ResponseEntity.ok(appointmentService.getAppointmentsByPatientId(patientId));
    }

    @GetMapping("by-id/{appointmentId}")
    public ResponseEntity<?> getAppointmentById(@PathVariable Integer appointmentId) {
        return ResponseEntity.ok(appointmentService.getAppointmentById(appointmentId));
    }

    @GetMapping("available-slots")
    public ResponseEntity<?> getAvailableSlots(Integer doctorId, LocalDate date) {
        return ResponseEntity.ok(appointmentService.getAvailableSlots(doctorId, date));
    }


    @PostMapping("book")
    public ResponseEntity<?> bookAppointment(@RequestBody AppointmentRequest request) {
        return ResponseEntity.ok(appointmentService.bookAppointment(request));
    }

    @PutMapping("update/{appointmentId}")
    public ResponseEntity<?> updateAppointment(@PathVariable Integer appointmentId, @RequestBody AppointmentRequest request) {
        return ResponseEntity.ok(appointmentService.updateAppointment(request,appointmentId));
    }

    @DeleteMapping("cancel/{appointmentId}")
    public ResponseEntity<?> cancelAppointment(@PathVariable Integer appointmentId) {
        return ResponseEntity.ok(appointmentService.cancelAppointment(appointmentId));
    }
}
