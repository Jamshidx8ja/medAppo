package com.example.med_appointment.service.impl;

import com.example.med_appointment.dto.request.ScheduleRequest;
import com.example.med_appointment.dto.response.ScheduleResponse;
import com.example.med_appointment.entity.Doctor;
import com.example.med_appointment.entity.Schedule;
import com.example.med_appointment.mapper.ScheduleMapper;
import com.example.med_appointment.repository.DoctorRepository;
import com.example.med_appointment.repository.ScheduleRepository;
import com.example.med_appointment.service.ScheduleService;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Server
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final DoctorRepository doctorRepository;
    private final ScheduleMapper scheduleMapper;

    @Override
    public ScheduleResponse getScheduleByDoctorId(Integer doctorId) {
        Schedule schedule = scheduleRepository.findById(doctorId)
                .orElseThrow(EntityNotFoundException::new);

        return scheduleMapper.toResponse(schedule);
    }

    @Override
    public Object createSchedule(ScheduleRequest request) {
        Schedule schedule = scheduleMapper.toEntity(request);
        scheduleRepository.save(schedule);

        return scheduleMapper.toResponse(schedule);
    }

    @Override
    public Object updateSchedule(ScheduleRequest request, Integer scheduleId) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(EntityNotFoundException::new);
        scheduleMapper.updateEntity(request, schedule);
        return scheduleMapper.toResponse(schedule);
    }

    @Override
    public Object deleteScheduleByDoctorId(Integer doctorId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(()->new EntityNotFoundException("Doctor not found"));

        scheduleRepository.deleteByDoctorId(doctorId);

        return "Schedule has been deleted";
    }
}
