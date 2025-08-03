package com.example.med_appointment.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private String specialty;
    private String email;

}
