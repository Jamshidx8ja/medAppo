package com.example.med_appointment.service;

import com.example.med_appointment.dto.request.DoctorRequest;
import com.example.med_appointment.dto.response.DoctorResponse;
import com.example.med_appointment.filter.DoctorFilter;

import java.util.List;

public interface DoctorService {
    List<DoctorResponse> getDoctorsList(DoctorFilter filter);
    DoctorResponse getDoctorById(Integer doctorId);

    Object createDoctor(DoctorRequest request);
    Object updateDoctor(DoctorRequest request, Integer doctorId);
    Object deleteDoctor(Integer doctorId);
}
