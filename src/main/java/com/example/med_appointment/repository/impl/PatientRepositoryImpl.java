package com.example.med_appointment.repository.impl;

import com.example.med_appointment.entity.Patient;
import com.example.med_appointment.filter.PatientFilter;
import com.example.med_appointment.repository.custom.PatientCustomRepository;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

public class PatientRepositoryImpl implements PatientCustomRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Patient> findAllByFilter(PatientFilter filter) {
        StringBuilder sql = new StringBuilder("select p from Patient p where 1=1 ");

        if(StringUtils.isNotEmpty(filter.getSearchKey())){
            sql.append(" and (lower(p.firstName) like :searchKey " +
                       " or lower(p.lastName) like :searchKey " +
                       " or lower(concat(p.firstName, ' ', p.lastName)) like :searchKey) ");
        }

        String countSql = sql.toString().replace("select p", "select count(p)");

        TypedQuery<Patient> queryForSearchKey = entityManager.createQuery(sql.toString(), Patient.class)
                .setFirstResult(filter.getPage() * filter.getSize())
                .setMaxResults(filter.getSize());



        TypedQuery<Long> countQuery = entityManager.createQuery(countSql, Long.class);

        if(StringUtils.isNotEmpty(filter.getSearchKey())){
            queryForSearchKey.setParameter("searchKey", filter.getSearchKey());
            countQuery.setParameter("searchKey", filter.getSearchKey());
        }

        return new PageImpl<>(queryForSearchKey.getResultList(), filter.getPageable(), countQuery.getSingleResult());
    }
}
