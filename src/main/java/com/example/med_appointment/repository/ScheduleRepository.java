package com.example.med_appointment.repository;

import com.example.med_appointment.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer> {
    Optional<Schedule> findByDoctorIdAndDayOfWeek(int doctorId, DayOfWeek dayOfWeek);
}
