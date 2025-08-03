package com.example.med_appointment.dto.response;

import com.example.med_appointment.entity.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientResponse {

    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Gender gender;
}
