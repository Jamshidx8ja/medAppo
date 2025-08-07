package com.example.med_appointment.repository.custom;

import com.example.med_appointment.entity.Patient;
import com.example.med_appointment.filter.PatientFilter;
import org.springframework.data.domain.Page;

public interface PatientCustomRepository {
    Page<Patient> findAllByFilter(PatientFilter filter);
}
