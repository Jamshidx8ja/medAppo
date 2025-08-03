package com.example.med_appointment.entity;

import com.example.med_appointment.entity.enums.Status;
import com.example.med_appointment.entity.template.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Appointment extends BaseEntity {
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Patient patient;

    @ManyToOne(optional = false,  fetch = FetchType.LAZY)
    private Doctor doctor;

    @Column(length = 200, columnDefinition = "text")
    private String notes;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss")
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
}
