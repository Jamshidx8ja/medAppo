package com.example.med_appointment.dto.response;

import java.time.LocalDateTime;

public class AppointmentResponse {
    private Integer appointmentId;
    private String doctorName;
    private String patientName;
    private LocalDateTime appointmentTime;
}
