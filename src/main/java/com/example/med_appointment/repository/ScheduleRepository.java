package com.example.med_appointment.repository;

import com.example.med_appointment.entity.Schedule;
import com.example.med_appointment.service.ScheduleService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule,Integer>, ScheduleCompositeRepository {

    void deleteByDoctorId(Integer doctorId);
}
