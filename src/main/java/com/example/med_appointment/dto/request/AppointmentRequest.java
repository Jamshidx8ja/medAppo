package com.example.med_appointment.dto.request;

import com.example.med_appointment.entity.enums.Slot;

import java.time.LocalDate;

public class AppointmentRequest {

    private Integer patientId;
    private Integer doctorId;
    private LocalDate date;
    private Slot slot;

}
