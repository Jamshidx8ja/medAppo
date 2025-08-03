package com.example.med_appointment.service;

import com.example.med_appointment.dto.request.ScheduleRequest;
import com.example.med_appointment.dto.response.ScheduleResponse;
import org.springframework.stereotype.Service;

@Service
public interface ScheduleService {
    ScheduleResponse getScheduleByDoctorId(Integer doctorId);

    Object createSchedule(ScheduleRequest request);
    Object updateSchedule(ScheduleRequest request, Integer scheduleId);
    Object deleteScheduleByDoctorId(Integer doctorId);
}
