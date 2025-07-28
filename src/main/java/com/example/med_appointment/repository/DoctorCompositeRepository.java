package com.example.med_appointment.repository;

import com.example.med_appointment.entity.Doctor;
import com.example.med_appointment.filter.DoctorFilter;
import org.springframework.data.domain.Page;

public interface DoctorCompositeRepository {
    Page<Doctor> findAllBYFilter(DoctorFilter filter);
}
