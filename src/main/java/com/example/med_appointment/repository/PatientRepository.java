package com.example.med_appointment.repository;

import com.example.med_appointment.entity.Patient;
import com.example.med_appointment.repository.custom.PatientCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer>, PatientCustomRepository {
}
