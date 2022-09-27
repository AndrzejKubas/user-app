package com.office.usersapp.repository;

import com.office.usersapp.data.model.EmployeeEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<EmployeeEntity> findEntitiesByParameters(Map<String, Object> parameters) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<EmployeeEntity> criteriaQuery = criteriaBuilder.createQuery(EmployeeEntity.class);
        Root<EmployeeEntity> root = criteriaQuery.from(EmployeeEntity.class);
        List<Predicate> predicates = new ArrayList<>(parameters.size());
        parameters.entrySet().forEach(entrySet -> predicates.add(criteriaBuilder.equal(root.get(entrySet.getKey()), entrySet.getValue())));
        if (parameters.size() != 0) {
            criteriaQuery.select(root).where(predicates.toArray(Predicate[]::new));
        } else {
            criteriaQuery.select(root);
        }
        Query<EmployeeEntity> query = (Query<EmployeeEntity>) entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
