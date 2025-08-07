package com.example.med_appointment.repository.impl;

import com.example.med_appointment.entity.Doctor;
import com.example.med_appointment.filter.DoctorFilter;
import com.example.med_appointment.repository.custom.DoctorCustomRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Repository;

@Repository
public class DoctorRepositoryImpl implements DoctorCustomRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Doctor> findAllBYFilter(DoctorFilter filter) {
        StringBuilder sql = new StringBuilder("select d from Doctor d where 1=1 ");

        if(StringUtils.isNotEmpty(filter.getSearchKey())){
            sql.append(" and (lower(d.firstName) like :searchKey " +
                    " or lower(d.lastName) like :searchKey " +
                    " or lower(concat(d.firstName, ' ', d.lastName)) like :searchKey) ");
        }

        String countSql = sql.toString().replace("select d", "select count(d)");

        TypedQuery<Doctor> queryForSearchKey = entityManager.createQuery(sql.toString(), Doctor.class)
                .setFirstResult(filter.getPage() * filter.getSize())
                .setMaxResults(filter.getSize());



        TypedQuery<Long> countQuery = entityManager.createQuery(countSql, Long.class);

        if(StringUtils.isNotEmpty(filter.getSearchKey())){
            queryForSearchKey.setParameter("firstName", filter.getFirstName());
            queryForSearchKey.setParameter("lastName", filter.getLastName());
            countQuery.setParameter("firstName", filter.getFirstName());
            countQuery.setParameter("lastName", filter.getLastName());
        }

        return new PageImpl<>(queryForSearchKey.getResultList(), filter.getPageable(), countQuery.getSingleResult());
    }
}
