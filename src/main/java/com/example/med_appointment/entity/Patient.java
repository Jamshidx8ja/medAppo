package com.example.med_appointment.entity;

import com.example.med_appointment.entity.enums.Gender;
import com.example.med_appointment.entity.template.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Patient extends User {

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false, length = 12)
    private Integer phoneNumber;
}
