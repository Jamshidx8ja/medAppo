package com.example.med_appointment.entity.enums;

import lombok.Getter;
import java.time.LocalTime;

@Getter
public enum Slot {
    SESSION9(LocalTime.of(9, 0), LocalTime.of(9, 30)),
    SESSION10(LocalTime.of(10, 0), LocalTime.of(10, 30)),
    SESSION11(LocalTime.of(11, 0), LocalTime.of(11, 30)),
    SESSION12(LocalTime.of(12, 0), LocalTime.of(12, 30)),
    SESSION14(LocalTime.of(14, 0), LocalTime.of(14, 30)),
    SESSION15(LocalTime.of(15, 0), LocalTime.of(15, 30)),
    SESSION16(LocalTime.of(16, 0), LocalTime.of(16, 30)),
    SESSION17(LocalTime.of(17, 0), LocalTime.of(17, 30));

    private final LocalTime startTime;
    private final LocalTime endTime;

    Slot(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getSlotText(){
        return this.startTime.toString() + " - " + this.endTime.toString();
    }
}
