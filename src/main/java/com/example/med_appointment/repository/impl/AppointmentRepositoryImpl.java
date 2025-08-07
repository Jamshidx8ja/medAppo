package com.example.med_appointment.repository.impl;

import com.example.med_appointment.entity.Appointment;
import com.example.med_appointment.filter.AppointmentFilter;
import com.example.med_appointment.repository.custom.AppointmentCustomRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

public class AppointmentRepositoryImpl implements AppointmentCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Appointment> findAllByFilter(AppointmentFilter filter) {
        StringBuilder sql = new StringBuilder("select a from Appointment a where 1=1 ");

        if(filter.getDoctorId() != null){
            sql.append(" and a.doctor.id = :doctorId ");
        }

        String countSql = sql.toString().replace("select a", "select count(a)");

        TypedQuery<Appointment> queryForDoctorId = entityManager.createQuery(sql.toString(), Appointment.class)
                .setFirstResult(filter.getPage() * filter.getSize())
                .setMaxResults(filter.getSize());

        TypedQuery<Long> countQuery = entityManager.createQuery(countSql, Long.class);

        if(filter.getDoctorId() != null){
            queryForDoctorId.setParameter("doctorId", filter.getDoctorId());
            countQuery.setParameter("doctorId", filter.getDoctorId());
        }

        return new PageImpl<>(queryForDoctorId.getResultList(), filter.getPageable(), countQuery.getSingleResult());

    }
}
