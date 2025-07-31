package com.example.med_appointment.service.impl;

import com.example.med_appointment.dto.request.PatientRequest;
import com.example.med_appointment.dto.response.PatientResponse;
import com.example.med_appointment.entity.Patient;
import com.example.med_appointment.filter.PatientFilter;
import com.example.med_appointment.mapper.PatientMapper;
import com.example.med_appointment.repository.PatientRepository;
import com.example.med_appointment.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public List<PatientResponse> getPatientsList(PatientFilter filter) {

        return patientRepository.findAllByFilter(filter).getContent()
                .stream().map(patientMapper::toResponse).toList();
    }

    @Override
    public Object createPatient(PatientRequest request) {

        Patient patient = patientMapper.toEntity(request);
        patientRepository.save(patient);
        return patientMapper.toResponse(patient);
    }

    @Override
    public Object updatePatient(PatientRequest request, Integer patientId) {

        Patient patient = patientRepository.findById(patientId).orElseThrow();
        patientMapper.updateEntity(request, patient);
        patientRepository.save(patient);
        return patientMapper.toResponse(patient);
    }

    @Override
    public Object deletePatient(Integer patientId) {
        patientRepository.deleteById(patientId);
        return "GG, Patient";
    }
}
