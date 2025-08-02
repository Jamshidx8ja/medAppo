package com.example.med_appointment.entity.enums;

import lombok.Getter;

import java.time.LocalTime;

@Getter
public enum Slot {
    SLOT1(LocalTime.of(9, 0), LocalTime.of(9, 30)),
    SLOT2(LocalTime.of(11, 0), LocalTime.of(11, 30));
    private final LocalTime startTime;
    private final LocalTime endTime;

    Slot(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getSlotText() {
        return this.startTime.toString() + " - " + this.endTime.toString();
    }
}
