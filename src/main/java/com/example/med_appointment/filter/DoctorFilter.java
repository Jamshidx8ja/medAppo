package com.example.med_appointment.filter;

import com.example.med_appointment.entity.Doctor;
import com.example.med_appointment.entity.enums.SortType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorFilter extends BaseFilter {
    private String firstName;
    private String lastName;
}
