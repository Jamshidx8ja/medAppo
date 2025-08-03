package com.example.med_appointment.dto.request;

import com.example.med_appointment.entity.enums.Slot;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class AppointmentRequest {

    @NotBlank
    private Integer patientId;
    @NotBlank
    private Integer doctorId;
    @NotBlank
    private LocalDateTime dateTime;
    @NotBlank
    private Slot slot;
    @NotBlank
    private String notes;


}
