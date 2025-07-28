package com.example.med_appointment.repository;

import com.example.med_appointment.entity.Doctor;
import com.example.med_appointment.filter.DoctorFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Integer>, DoctorCompositeRepository {

}
