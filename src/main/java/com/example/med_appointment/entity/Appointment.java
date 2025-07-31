package com.example.med_appointment.entity;

import com.example.med_appointment.entity.template.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Appointment extends BaseEntity {
    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    @Column(length = 200, columnDefinition = "text")
    private String notes;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime appointmentTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private String status;
}
