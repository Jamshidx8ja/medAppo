package com.example.med_appointment.service.impl;

import com.example.med_appointment.dto.TimeSlotDTO;
import com.example.med_appointment.dto.request.AppointmentRequest;
import com.example.med_appointment.dto.response.AppointmentResponse;
import com.example.med_appointment.entity.Appointment;
import com.example.med_appointment.entity.Doctor;
import com.example.med_appointment.entity.Patient;
import com.example.med_appointment.entity.Schedule;
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

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
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
    public Optional<AppointmentResponse> getAppointmentById(Integer appointmentId) {
        return appointmentRepository.findById(appointmentId)
                .map(appointmentMapper::toResponse);
    }

    @Override
    public Object bookAppointment(AppointmentRequest request) {


        Doctor doctor = doctorRepository.findById(request.getDoctorId()).orElseThrow(() -> new EntityNotFoundException("Doctor not found"));
        Patient patient = patientRepository.findById(request.getPatientId()).orElseThrow(() -> new EntityNotFoundException("Patient not found"));

        LocalDateTime dateTime = request.getDateTime();


        if (appointmentRepository.existsByDoctorAndDateTime(doctor, dateTime)) {
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
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow();
        appointmentMapper.updateEntity(request, appointment);
        return appointmentMapper.toResponse(appointment);
    }

    @Override
    public Object cancelAppointment(Integer appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new EntityNotFoundException("Appointment not found"));
        appointment.setStatus(Status.CANCELLED);
        appointmentRepository.save(appointment);
        return "In the bleak midwinter";
    }

    @Override
    public List<TimeSlotDTO> getAvailableSlots(Integer doctorId, LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        Schedule schedule = scheduleRepository.findByDoctorIdAndDayOfWeek(doctorId, dayOfWeek)
                .orElseThrow(() -> new EntityNotFoundException("Schedule not found"));
        List<LocalDateTime> slots = new ArrayList<>();

        for (LocalTime time = schedule.getStartTime(); time.isBefore(schedule.getEndTime()); time.plusMinutes(schedule.getSlotDuration())) {
            slots.add(LocalDateTime.of(date, time));
        }

        List<LocalDateTime> bookedSlots = appointmentRepository.findAllByDoctorIdAndDate(doctorId, date).stream()
                .map(Appointment::getDateTime).toList();

        return slots.stream()
                .filter(slot -> !bookedSlots.contains(slot))
                .map(TimeSlotDTO::new).toList();
    }
}
