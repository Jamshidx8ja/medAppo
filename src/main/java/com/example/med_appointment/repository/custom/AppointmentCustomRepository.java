package com.example.med_appointment.repository.custom;

import com.example.med_appointment.entity.Appointment;
import com.example.med_appointment.entity.Doctor;
import com.example.med_appointment.filter.AppointmentFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentCustomRepository {

    Page<Appointment> findAllByFilter(AppointmentFilter filter);

}
