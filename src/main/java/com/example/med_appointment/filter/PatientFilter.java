package com.example.med_appointment.filter;

import com.example.med_appointment.entity.enums.SortType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientFilter {
    private Integer size;
    private Integer page;
    private String searchKey;
    private SortType sortType;
    private Integer doctorId;
}
