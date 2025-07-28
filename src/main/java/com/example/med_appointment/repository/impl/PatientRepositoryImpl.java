package com.example.med_appointment.repository.impl;

import com.example.med_appointment.entity.Patient;
import com.example.med_appointment.filter.PatientFilter;
import com.example.med_appointment.repository.PatientCompositeRepository;
import org.springframework.data.domain.Page;

public class PatientRepositoryImpl implements PatientCompositeRepository {
    @Override
    public Page<Patient> findAllByFilter(PatientFilter filter) {
        return null;
    }
}
