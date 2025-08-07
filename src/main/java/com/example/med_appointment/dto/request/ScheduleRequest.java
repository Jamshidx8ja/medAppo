package com.example.med_appointment.dto.request;

import com.example.med_appointment.entity.enums.Slot;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;

@AllArgsConstructor
@Getter
@Setter
public class ScheduleRequest {

    @NotBlank
    private Integer doctorId;
    @NotBlank
    private DayOfWeek dayOfWeek;
    @NotBlank
    private Slot slot;
}
