package com.example.med_appointment.repository.custom;

import com.example.med_appointment.entity.Doctor;
import com.example.med_appointment.filter.DoctorFilter;
import org.springframework.data.domain.Page;

public interface DoctorCustomRepository {
    Page<Doctor> findAllBYFilter(DoctorFilter filter);
}
