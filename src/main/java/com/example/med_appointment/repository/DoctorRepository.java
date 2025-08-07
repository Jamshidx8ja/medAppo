package com.example.med_appointment.repository;

import com.example.med_appointment.entity.Doctor;
import com.example.med_appointment.repository.custom.DoctorCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>, DoctorCustomRepository {

}
