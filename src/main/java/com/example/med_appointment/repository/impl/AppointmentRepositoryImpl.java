package com.example.med_appointment.repository.impl;

import com.example.med_appointment.entity.Appointment;
import com.example.med_appointment.filter.AppointmentFilter;
import com.example.med_appointment.filter.PatientFilter;
import com.example.med_appointment.repository.AppointmentCompositeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public class AppointmentRepositoryImpl implements AppointmentCompositeRepository {
   @PersistenceContext
   private EntityManager entityManager;



    @Override
    public Page<Appointment> findAllByFilter(AppointmentFilter filter) {
        return null;
    }
}
