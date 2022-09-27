package com.office.usersapp.service;

import com.office.usersapp.data.dto.EmployeeDTO;
import com.office.usersapp.data.model.EmployeeEntity;
import com.office.usersapp.repository.EmployeeRepository;
import com.office.usersapp.repository.EmployeeRepositoryCustom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeRepositoryCustom employeeRepositoryCustom;

    private ModelMapper modelMapper;

    private EmployeeService() {
        this.modelMapper = new ModelMapper();
    }

    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        return modelMapper.map(employeeRepository.save(modelMapper.map(employeeDTO, EmployeeEntity.class)), EmployeeDTO.class);
    }

    public EmployeeDTO getEmployee(final int id) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(id);
        if (employeeEntity.isPresent()) {
            return modelMapper.map(employeeEntity.get() , EmployeeDTO.class);
        }
        return null;
    }

    public List<EmployeeDTO> getEmployees(Map<String, Object> parameters) {
        return employeeRepositoryCustom.findEntitiesByParameters(parameters)
                .stream()
                .map(item -> modelMapper.map(item, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
        if (employeeRepository.existsById(employeeDTO.getId())) {
            return modelMapper.map(employeeRepository.save(modelMapper.map(employeeDTO, EmployeeEntity.class)), EmployeeDTO.class);
        } else {
            return null;
        }
    }

    public void removeEmployee(final int id) {
        employeeRepository.deleteById(id);
    }
}
