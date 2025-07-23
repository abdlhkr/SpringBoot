package com.example.JWT.service.service_impl;

import com.example.JWT.dto.DtoDepartment;
import com.example.JWT.dto.DtoEmployee;
import com.example.JWT.entity.Employee;
import com.example.JWT.repository.EmployeeRepository;
import com.example.JWT.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;


    @Override
    public DtoEmployee findById(long id) {
        Optional<Employee> employee = repository.findById(id);
        if (employee.isPresent()) {
            DtoEmployee dtoEmployee = new DtoEmployee();
            BeanUtils.copyProperties(employee.get(), dtoEmployee);
            DtoDepartment dtoDepartment = new DtoDepartment();
            BeanUtils.copyProperties(employee.get().getDepartment(), dtoDepartment);
            dtoEmployee.setDepartment(dtoDepartment);
            return dtoEmployee;
        }
        return null;
    }
}
