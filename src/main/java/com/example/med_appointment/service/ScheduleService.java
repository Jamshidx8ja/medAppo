package com.example.med_appointment.service;

import com.example.med_appointment.dto.request.ScheduleRequest;
import com.example.med_appointment.dto.response.ScheduleResponse;
import com.example.med_appointment.filter.ScheduleFilter;

import java.util.List;
import java.util.Optional;

public interface ScheduleService {
    Optional<ScheduleResponse> getScheduleByDoctorId(Integer doctorId);

    Object createSchedule(ScheduleRequest request);
    Object updateSchedule(ScheduleRequest request, Integer scheduleId);
    Object deleteScheduleByDoctorId(Integer scheduleId);
}
