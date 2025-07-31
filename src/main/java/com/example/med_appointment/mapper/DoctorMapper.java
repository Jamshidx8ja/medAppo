package com.example.med_appointment.mapper;

import com.example.med_appointment.dto.request.DoctorRequest;
import com.example.med_appointment.dto.response.DoctorResponse;
import com.example.med_appointment.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

   Doctor toEntity(DoctorRequest doctorRequest);

   DoctorResponse toResponse(Doctor doctor);
   void updateEntity(DoctorRequest request, @MappingTarget Doctor doctor);
}
