package com.example.med_appointment.service;

import com.example.med_appointment.dto.request.AppointmentRequest;
import com.example.med_appointment.dto.response.AppointmentResponse;
import com.example.med_appointment.entity.Appointment;
import com.example.med_appointment.filter.AppointmentFilter;

import java.util.List;

public interface AppointmentService {
    List<AppointmentResponse> getAppointmentsList(AppointmentFilter filter);
    Object createAppointment(AppointmentRequest request);
    Object updateAppointment(AppointmentRequest request, Integer appointmentId);
    Object deleteAppointment(Integer appointmentId);
}
