package com.example.med_appointment.service;

import com.example.med_appointment.dto.request.PatientRequest;
import com.example.med_appointment.dto.response.PatientResponse;
import com.example.med_appointment.entity.Patient;
import com.example.med_appointment.filter.PatientFilter;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

public interface PatientService {
    List<PatientResponse> getPatientsList(PatientFilter filter);
    Optional<PatientResponse> getPatientById(Integer patientId);

    Object createPatient(PatientRequest request);
    Object updatePatient(PatientRequest request, Integer patientId);
    Object deletePatient(Integer patientId);
}
