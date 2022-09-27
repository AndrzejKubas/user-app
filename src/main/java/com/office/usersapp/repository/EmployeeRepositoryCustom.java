package com.office.usersapp.repository;

import com.office.usersapp.data.model.EmployeeEntity;

import java.util.List;
import java.util.Map;

public interface EmployeeRepositoryCustom {
    List<EmployeeEntity> findEntitiesByParameters(Map<String, Object> parameters);
}
