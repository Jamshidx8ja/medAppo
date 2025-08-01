package com.example.med_appointment.repository;

import com.example.med_appointment.entity.Schedule;
import com.example.med_appointment.filter.ScheduleFilter;
import org.springframework.data.domain.Page;

public interface ScheduleCompositeRepository {
    Page<Schedule> findAllByFiler(ScheduleFilter filter);
}
