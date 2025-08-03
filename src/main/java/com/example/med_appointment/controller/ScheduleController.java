package com.example.med_appointment.controller;

import com.example.med_appointment.dto.request.ScheduleRequest;
import com.example.med_appointment.dto.response.ScheduleResponse;
import com.example.med_appointment.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/v1/schedule")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService service;

    @GetMapping("doctor-schedule/{doctorId}")
    public ResponseEntity<?> getScheduleByDoctorId(@RequestParam Integer doctorId){
        ScheduleResponse response = service.getScheduleByDoctorId(doctorId);
        return ResponseEntity.ok(response);
    }

    @PostMapping("create")
    public ResponseEntity<?> create(@RequestBody ScheduleRequest request){
        return ResponseEntity.ok(service.createSchedule(request));
    }

    @PutMapping("update/{scheduleId}")
    public ResponseEntity<?> update(@RequestBody ScheduleRequest request, @PathVariable Integer scheduleId){
        return ResponseEntity.ok(service.updateSchedule(request, scheduleId));
    }

    @DeleteMapping("delete/{doctorId}")
    public ResponseEntity<?> delete(@PathVariable Integer doctorId){
        return ResponseEntity.ok(service.deleteScheduleByDoctorId(doctorId));
    }
}
