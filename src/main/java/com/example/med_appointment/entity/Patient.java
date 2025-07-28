package com.example.med_appointment.entity;

import com.example.med_appointment.entity.enums.Gender;
import com.example.med_appointment.entity.template.User;
import com.jayway.jsonpath.internal.function.numeric.Min;
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

    private int age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

}
