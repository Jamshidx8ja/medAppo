package com.example.med_appointment.service.impl;

import com.example.med_appointment.dto.request.DoctorRequest;
import com.example.med_appointment.dto.response.DoctorResponse;
import com.example.med_appointment.entity.Doctor;
import com.example.med_appointment.filter.DoctorFilter;
import com.example.med_appointment.mapper.DoctorMapper;
import com.example.med_appointment.repository.DoctorRepository;
import com.example.med_appointment.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public List<DoctorResponse> getDoctorsList(DoctorFilter filter) {

        return doctorRepository.findAllBYFilter(filter).getContent()
                .stream().map(doctorMapper::toResponse).toList();
    }

    @Override
    public Optional<DoctorResponse> getDoctorById(Integer doctorId) {
        return doctorRepository.findById(doctorId)
                .map(doctorMapper::toResponse);
    }


    @Override
    public Object createDoctor(DoctorRequest request) {

        Doctor doctor = doctorMapper.toEntity(request);
        doctorRepository.save(doctor);
        return doctorMapper.toResponse(doctor);
    }

    @Override
    public Object updateDoctor(DoctorRequest request, Integer doctorId) {

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doc not found"));

        doctorMapper.updateEntity(request, doctor);
        doctorRepository.save(doctor);
        return doctorMapper.toResponse(doctor);
    }

    @Override
    public Object deleteDoctor(Integer doctorId) {
        doctorRepository.deleteById(doctorId);
        return "Bye, Mr Doc";
    }
}
