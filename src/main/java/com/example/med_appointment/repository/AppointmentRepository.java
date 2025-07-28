package com.example.med_appointment.repository;

import com.example.med_appointment.entity.Appointment;
import com.example.med_appointment.filter.PatientFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>, AppointmentCompositeRepository {

}
