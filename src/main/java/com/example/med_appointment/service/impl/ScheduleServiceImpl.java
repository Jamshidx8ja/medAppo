package com.example.med_appointment.service.impl;

import com.example.med_appointment.dto.request.ScheduleRequest;
import com.example.med_appointment.dto.response.ScheduleResponse;
import com.example.med_appointment.mapper.ScheduleMapper;
import com.example.med_appointment.repository.ScheduleRepository;
import com.example.med_appointment.service.ScheduleService;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Server
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;

    @Override
    public Optional<ScheduleResponse> getScheduleByDoctorId(Integer doctorId) {
        return Optional.empty();
    }

    @Override
    public Object createSchedule(ScheduleRequest request) {
        return null;
    }

    @Override
    public Object updateSchedule(ScheduleRequest request, Integer scheduleId) {
        return null;
    }

    @Override
    public Object deleteScheduleByDoctorId(Integer scheduleId) {
        return null;
    }
}
