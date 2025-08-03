package com.example.med_appointment.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentResponse {
    private Integer id;
    private String doctorName;
    private String patientName;
    private LocalDateTime appointmentDate;
    private String notes;

}
