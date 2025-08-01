package com.example.med_appointment.mapper;

import com.example.med_appointment.dto.request.AppointmentRequest;
import com.example.med_appointment.dto.response.AppointmentResponse;
import com.example.med_appointment.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    AppointmentMapper INSTANCE = Mappers.getMapper(AppointmentMapper.class);
    Appointment  toEntity(AppointmentRequest request);

    @Mapping(target = "doctorName", source = "doctor.name")
    @Mapping(target = "patientName", source = "patient.name")
    AppointmentResponse toResponse(Appointment appointment);

    void updateEntity(AppointmentRequest request, @MappingTarget Appointment appointment);
}
