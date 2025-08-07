package com.example.med_appointment.dto.response;

import com.example.med_appointment.entity.enums.Slot;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;

@Getter
@Setter
public class ScheduleResponse {
    private Integer id;
    private Integer doctorId;
    private DayOfWeek dayOfWeek;
    private Slot slot;

}
