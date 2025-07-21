package com.example.exception_handling.service.Service.IMPL;

import com.example.exception_handling.dto.DtoDepartment;
import com.example.exception_handling.entity.Department;
import com.example.exception_handling.repository.DepartmentRepository;
import com.example.exception_handling.service.IDepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private DepartmentRepository repository;

    @Override
    public DtoDepartment addDepartment(DtoDepartment department) {
        Department createdDepartment = new Department();
        BeanUtils.copyProperties(department, createdDepartment);
        Department dbDepartment = repository.save(createdDepartment);
        DtoDepartment dtoDepartment = new DtoDepartment();
        BeanUtils.copyProperties(dbDepartment, dtoDepartment);
        return dtoDepartment;
    }

    @Override
    public DtoDepartment findById(Long id) {
       Optional<Department> department = repository.findById(id);
         if(department.isEmpty()){
              return null;
         } else {
              DtoDepartment dtoDepartment = new DtoDepartment();
              BeanUtils.copyProperties(department.get(), dtoDepartment);
              return dtoDepartment;
         }
    }

    @Override
    public List<DtoDepartment> getAllDepartments() {
        return repository.findAll().stream()
                .map(department -> {
                    DtoDepartment dtoDepartment = new DtoDepartment();
                    BeanUtils.copyProperties(department, dtoDepartment);
                    return dtoDepartment;
                }).toList();
    }
}
