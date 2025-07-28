package com.example.med_appointment.repository.impl;

import com.example.med_appointment.entity.Doctor;
import com.example.med_appointment.filter.DoctorFilter;
import com.example.med_appointment.repository.DoctorCompositeRepository;
import com.example.med_appointment.repository.DoctorRepository;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorRepositoryImpl implements DoctorCompositeRepository {
    @Override
    public Page<Doctor> findAllBYFilter(DoctorFilter filter) {
        return null;
    }
}
