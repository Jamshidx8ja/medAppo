package com.example.med_appointment.service.impl;

import com.example.med_appointment.dto.request.AppointmentRequest;
import com.example.med_appointment.dto.response.AppointmentResponse;
import com.example.med_appointment.entity.Appointment;
import com.example.med_appointment.filter.AppointmentFilter;
import com.example.med_appointment.mapper.AppointmentMapper;
import com.example.med_appointment.repository.AppointmentRepository;
import com.example.med_appointment.repository.DoctorRepository;
import com.example.med_appointment.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository  appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    @Override
    public List<AppointmentResponse> getAppointmentsList(AppointmentFilter filter) {
        return appointmentRepository.findAllByFilter(filter).getContent()
                .stream().map(appointmentMapper::toResponse).toList();
    }

    @Override
    public List<AppointmentResponse> getAppointmentsByPatientId(Integer patientId) {
        return appointmentRepository.findById(patientId)
                .stream().map(appointmentMapper::toResponse).toList();
    }


    @Override
    public Optional<AppointmentResponse> getAppointmentById(Integer appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .map(appointmentMapper::toResponse);
    }

    @Override
    public Object bookAppointment(AppointmentRequest request) {

        Appointment appointment = appointmentMapper.toEntity(request);
        appointmentRepository.save(appointment);
        return appointmentMapper.toResponse(appointment);
    }

    @Override
    public Object updateAppointment(AppointmentRequest request, Integer appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        appointmentMapper.updateEntity(request, appointment);
        return appointmentMapper.toResponse(appointment);
    }

    @Override
    public Object deleteAppointment(Integer appointmentId) {
        appointmentRepository.deleteById(appointmentId);
        return "In the bleak midwinter";
    }
}
