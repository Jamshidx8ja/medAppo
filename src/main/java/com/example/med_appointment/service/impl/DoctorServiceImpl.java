package com.example.med_appointment.service.impl;

import com.example.med_appointment.dto.request.DoctorRequest;
import com.example.med_appointment.dto.response.DoctorResponse;
import com.example.med_appointment.filter.DoctorFilter;
import com.example.med_appointment.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    @Override
    public List<DoctorResponse> getDoctorsList(DoctorFilter filter) {
        return List.of();
    }

    @Override
    public Object createDoctor(DoctorRequest request) {
        return null;
    }

    @Override
    public Object updateDoctor(DoctorRequest request, Integer doctorId) {
        return null;
    }

    @Override
    public Object deleteDoctor(Integer doctorId) {
        return null;
    }
}
