package com.example.med_appointment.filter;

import com.example.med_appointment.entity.enums.SortType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.relational.core.sql.In;

@Getter
@Setter
public class AppointmentFilter {
    private Integer size;
    private Integer page;
    private String searchKey;
    private SortType sortType;
}
