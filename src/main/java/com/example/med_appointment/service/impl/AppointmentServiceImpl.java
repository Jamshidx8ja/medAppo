package com.example.med_appointment.service.impl;

import com.example.med_appointment.dto.request.AppointmentRequest;
import com.example.med_appointment.dto.response.AppointmentResponse;
import com.example.med_appointment.filter.AppointmentFilter;
import com.example.med_appointment.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    @Override
    public List<AppointmentResponse> getAppointmentsList(AppointmentFilter filter) {
        return List.of();
    }

    @Override
    public Object createAppointment(AppointmentRequest request) {
        return null;
    }

    @Override
    public Object updateAppointment(AppointmentRequest request, Integer appointmentId) {
        return null;
    }

    @Override
    public Object deleteAppointment(Integer appointmentId) {
        return null;
    }
}
