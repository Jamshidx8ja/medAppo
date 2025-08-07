package com.example.med_appointment.repository;

import com.example.med_appointment.entity.Appointment;
import com.example.med_appointment.entity.Doctor;
import com.example.med_appointment.repository.custom.AppointmentCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer>, AppointmentCustomRepository {

    boolean existsByDoctorAndDateTime(Doctor doctor, LocalDateTime dateTime);

    @Query( value = "select t from Appointment  t where t.doctor.id = :doctorId and function('DATE',t.dateTime) = :targetDate")
    List<Appointment> findAllByDoctorIdAndDate(Integer doctorId, LocalDate targetDate);
}
