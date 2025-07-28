package com.example.med_appointment.filter;

import com.example.med_appointment.entity.enums.SortType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorFilter {
    private Integer size = 10;
    private Integer page = 0;
    private String searchKey;
    private SortType sortType;
    private Integer patientId;
}
