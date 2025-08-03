package com.example.med_appointment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class TimeSlotDTO {
    private LocalDateTime dateTime;
}
