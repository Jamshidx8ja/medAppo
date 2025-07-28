package com.example.med_appointment.entity;

import com.example.med_appointment.entity.template.BaseEntity;
import jakarta.persistence.*;

@Entity
public class Appointment extends BaseEntity {
    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Doctor doctor;

    @Column(length = 200, columnDefinition = "text")
    private String notes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private String status;
}
