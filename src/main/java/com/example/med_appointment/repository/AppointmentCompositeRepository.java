package com.example.med_appointment.repository;

import com.example.med_appointment.entity.Appointment;
import com.example.med_appointment.filter.AppointmentFilter;
import com.example.med_appointment.filter.PatientFilter;
import org.springframework.data.domain.Page;

public interface AppointmentCompositeRepository {
    Page<Appointment> findAllByFilter(AppointmentFilter filter);
}
