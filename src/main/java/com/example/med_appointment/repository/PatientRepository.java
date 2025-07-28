package com.example.med_appointment.repository;

import com.example.med_appointment.entity.Patient;
import com.example.med_appointment.filter.PatientFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer>, PatientCompositeRepository {
}
