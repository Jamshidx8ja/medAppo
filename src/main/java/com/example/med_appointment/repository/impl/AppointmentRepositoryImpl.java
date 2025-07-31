package com.example.med_appointment.repository.impl;

import com.example.med_appointment.entity.Appointment;
import com.example.med_appointment.filter.AppointmentFilter;
import com.example.med_appointment.filter.PatientFilter;
import com.example.med_appointment.repository.AppointmentCompositeRepository;
import org.springframework.data.domain.Page;

public class AppointmentRepositoryImpl implements AppointmentCompositeRepository {
    @Override
    public Page<Appointment> findAllByFilter(AppointmentFilter filter) {
        return null;
    }
}
