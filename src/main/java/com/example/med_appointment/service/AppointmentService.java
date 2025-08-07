package com.example.med_appointment.service;

import com.example.med_appointment.dto.TimeSlotDTO;
import com.example.med_appointment.dto.request.AppointmentRequest;
import com.example.med_appointment.dto.response.AppointmentResponse;
import com.example.med_appointment.entity.Appointment;
import com.example.med_appointment.filter.AppointmentFilter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public interface AppointmentService {
    List<AppointmentResponse> getAppointmentsList(AppointmentFilter filter);
    List<AppointmentResponse> getAppointmentsByPatientId(Integer patientId);
    List<TimeSlotDTO> getAvailableSlots(Integer doctorId, LocalDate date);

    AppointmentResponse getAppointmentById(Integer appointmentId);

    Object bookAppointment(AppointmentRequest request);
    Object updateAppointment(AppointmentRequest request, Integer appointmentId);
    Object cancelAppointment(Integer appointmentId);

}



