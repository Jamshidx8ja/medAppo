package com.example.med_appointment.service.impl;

import com.example.med_appointment.dto.request.PatientRequest;
import com.example.med_appointment.dto.response.PatientResponse;
import com.example.med_appointment.filter.PatientFilter;
import com.example.med_appointment.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    @Override
    public List<PatientResponse> getPatientsList(PatientFilter filter) {
        return List.of();
    }

    @Override
    public Object createPatient(PatientRequest request) {
        return null;
    }

    @Override
    public Object updatePatient(PatientRequest request, Integer patientId) {
        return null;
    }

    @Override
    public Object deletePatient(Integer patientId) {
        return null;
    }
}
