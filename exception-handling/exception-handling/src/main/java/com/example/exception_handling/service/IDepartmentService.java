package com.example.exception_handling.service;

import com.example.exception_handling.dto.DtoDepartment;

import java.util.List;

public interface IDepartmentService {
    public DtoDepartment addDepartment(DtoDepartment department);
    public DtoDepartment findById(Long id);
    public List<DtoDepartment> getAllDepartments();
}
