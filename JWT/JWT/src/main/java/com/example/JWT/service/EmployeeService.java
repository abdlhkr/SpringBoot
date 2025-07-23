package com.example.JWT.service;

import com.example.JWT.dto.DtoEmployee;
import com.example.JWT.entity.Employee;

import java.util.Optional;

public interface EmployeeService {
    DtoEmployee findById(long id);
}
