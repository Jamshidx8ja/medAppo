package com.example.med_appointment.dto.request;

import com.example.med_appointment.entity.enums.Gender;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PatientRequest {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private Gender gender;
    @NotBlank
    private String email;
    @NotBlank
    private Integer phoneNumber;

}
