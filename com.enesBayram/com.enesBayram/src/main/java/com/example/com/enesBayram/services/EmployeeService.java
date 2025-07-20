package com.example.com.enesBayram.services;


import com.example.com.enesBayram.model.Employee;
import com.example.com.enesBayram.model.UpdateEmployeeRequest;
import com.example.com.enesBayram.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {

        return employeeRepository.getAllEmployees();
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.addEmployee(employee);
    }

    public Employee getEmployee(int id) throws Exception {
        return employeeRepository.getEmployeeById(id);
    }

    public List<Employee> getEmployeeWithParam(String firstName, String lastName) throws Exception {
        return employeeRepository.getEmployeeWithParam(firstName, lastName);
    }

    public boolean deleteEmployee(int id){
        return employeeRepository.deleteEmplooyee(id);
    }

    public Employee updateEmployee(int id, UpdateEmployeeRequest request) {
        return employeeRepository.updateEmployee(id, request);
    }
}
