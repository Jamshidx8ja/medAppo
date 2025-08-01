package com.example.med_appointment.mapper;

import com.example.med_appointment.dto.request.ScheduleRequest;
import com.example.med_appointment.dto.response.ScheduleResponse;
import com.example.med_appointment.entity.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
    ScheduleMapper MAPPER = Mappers.getMapper(ScheduleMapper.class);

    Schedule toEntity(ScheduleRequest request);
    ScheduleResponse toResponse(Schedule schedule);
    void  updateEntity(ScheduleRequest request, @MappingTarget Schedule schedule);
}
