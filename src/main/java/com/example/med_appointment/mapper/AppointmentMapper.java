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

    @Mapping(target = "doctorFirstName", source = "doctor.firstName")
    @Mapping(target = "doctorLastName", source = "doctor.lastName")
    @Mapping(target = "patientFirstName", source = "patient.firstName")
    @Mapping(target = "patientLastName", source = "patient.lastName")
    AppointmentResponse toResponse(Appointment appointment);

    void updateEntity(AppointmentRequest request, @MappingTarget Appointment appointment);
}
