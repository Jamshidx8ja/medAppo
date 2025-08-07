package com.example.med_appointment.repository;

import com.example.med_appointment.entity.Schedule;
import com.example.med_appointment.repository.custom.ScheduleCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.Optional;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer>, ScheduleCustomRepository {

    void deleteByDoctorId(Integer doctorId);

    Optional<Schedule> findByDoctorIdAndDayOfWeek(Integer doctorId, DayOfWeek dayOfWeek);

}
