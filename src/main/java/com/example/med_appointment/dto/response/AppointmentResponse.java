package com.example.med_appointment.dto.response;

import java.time.LocalDateTime;

public class AppointmentResponse {
    private Integer id;
    private String doctorName;
    private String patientName;
    private LocalDateTime appointmentDate;
    private String notes;

}
