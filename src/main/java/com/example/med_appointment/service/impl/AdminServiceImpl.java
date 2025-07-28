package com.example.med_appointment.service.impl;

import com.example.med_appointment.dto.request.AdminRequest;
import com.example.med_appointment.dto.response.AdminResponse;
import com.example.med_appointment.dto.response.PatientResponse;
import com.example.med_appointment.filter.AdminFilter;
import com.example.med_appointment.filter.PatientFilter;
import com.example.med_appointment.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    @Override
    public List<AdminResponse> getAdminList(AdminFilter filter) {
        return List.of();
    }

    @Override
    public List<PatientResponse> getPatientDetails(PatientFilter filter) {
        return List.of();
    }

    @Override
    public Object createAdmin(AdminRequest request) {
        return null;
    }

    @Override
    public Object updateAdmin(AdminRequest request, Integer adminId) {
        return null;
    }

    @Override
    public Object deleteAdmin(Integer adminId) {
        return null;
    }
}
