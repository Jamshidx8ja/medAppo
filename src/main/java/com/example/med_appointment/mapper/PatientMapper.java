package com.example.med_appointment.mapper;

import com.example.med_appointment.dto.request.DoctorRequest;
import com.example.med_appointment.dto.request.PatientRequest;
import com.example.med_appointment.dto.response.DoctorResponse;
import com.example.med_appointment.dto.response.PatientResponse;
import com.example.med_appointment.entity.Doctor;
import com.example.med_appointment.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);
    Patient toEntity(PatientRequest request);

    PatientResponse toResponse(Patient patient);
    void updateEntity(PatientRequest request, @MappingTarget Patient patient);
}
