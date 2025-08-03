package com.example.med_appointment.service.impl;

import com.example.med_appointment.dto.request.AppointmentRequest;
import com.example.med_appointment.dto.response.AppointmentResponse;
import com.example.med_appointment.entity.Appointment;
import com.example.med_appointment.entity.Doctor;
import com.example.med_appointment.entity.Patient;
import com.example.med_appointment.entity.enums.Status;
import com.example.med_appointment.filter.AppointmentFilter;
import com.example.med_appointment.mapper.AppointmentMapper;
import com.example.med_appointment.repository.AppointmentRepository;
import com.example.med_appointment.repository.DoctorRepository;
import com.example.med_appointment.repository.PatientRepository;
import com.example.med_appointment.repository.ScheduleRepository;
import com.example.med_appointment.service.AppointmentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository  appointmentRepository;
    private final AppointmentMapper appointmentMapper;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    private final ScheduleRepository scheduleRepository;


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
    public List<AppointmentResponse> getAvailableSessions(AppointmentFilter filter) {
        return List.of();
    }


    @Override
    public AppointmentResponse getAppointmentById(Integer appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));
        return appointmentMapper.toResponse(appointment);
    }

    @Override
    public Object bookAppointment(AppointmentRequest request) {

        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(()-> new EntityNotFoundException("Doctor not found"));
        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(()-> new EntityNotFoundException("Patient not found"));

        LocalDateTime dateTime = request.getDateTime();

        if(appointmentRepository.existsByDoctorAndDateTime(doctor, dateTime)){
            throw new RuntimeException("Appointment already exists");
        }

        Appointment appointment = appointmentMapper.toEntity(request);
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointment.setStatus(Status.BOOKED);
        appointmentRepository.save(appointment);
        return appointmentMapper.toResponse(appointment);
    }

    @Override
    public Object updateAppointment(AppointmentRequest request, Integer appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(()-> new EntityNotFoundException("Appointment not found"));
        appointmentMapper.updateEntity(request, appointment);
        return appointmentMapper.toResponse(appointment);
    }

    @Override
    public Object cancelAppointment(Integer appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new EntityNotFoundException("Appointment not found"));
        appointment.setStatus(Status.CANCELLED);
        appointmentRepository.save(appointment);

        return "Fare thee well";
    }


}
