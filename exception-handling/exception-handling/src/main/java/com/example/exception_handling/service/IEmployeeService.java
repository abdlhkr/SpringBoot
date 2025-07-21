package com.example.exception_handling.service;

import com.example.exception_handling.dto.DtoEmployee;
import com.example.exception_handling.dto.IUEmployee;

import java.util.List;

public interface IEmployeeService {
    DtoEmployee findById(Long id);
    DtoEmployee createEmployee(IUEmployee employee);
    List<DtoEmployee> getAllEmployees();
}
