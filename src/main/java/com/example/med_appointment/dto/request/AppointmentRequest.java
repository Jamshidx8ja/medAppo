package com.example.med_appointment.dto.request;

import com.example.med_appointment.entity.enums.Slot;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class AppointmentRequest {

    private Integer patientId;
    private Integer doctorId;
    private LocalDateTime dateTime;
    private Slot slot;

}
