package com.example.med_appointment.filter;

import com.example.med_appointment.entity.enums.SortType;
import com.example.med_appointment.entity.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AppointmentFilter extends BaseFilter {
    private Integer doctorId;
    private Integer patientId;
    private LocalDate fromDate;
    private LocalDate toDate;
    private Status status;

}
