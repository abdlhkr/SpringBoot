package com.example.com.enesBayram.repository;


import com.example.com.enesBayram.config.AppConfig;
import com.example.com.enesBayram.model.Employee;
import com.example.com.enesBayram.model.UpdateEmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    @Autowired
    private List<Employee> employeeList;

    public List<Employee> getAllEmployees() {
        return employeeList;
    }


    public Employee addEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    public Employee getEmployeeById(int id) throws Exception {
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new Exception("Employee not found");
    }


    public List<Employee> getEmployeeWithParam(String firstName, String lastName) throws Exception {
        List<Employee> employees = employeeList.stream()
                .filter(employee -> employee.getFirstName().equalsIgnoreCase(firstName) &&
                                   employee.getLastName().equalsIgnoreCase(lastName))
                .toList();
        System.out.println("Filtered Employees: " + employees);
        if(employees.isEmpty()) {
            throw new Exception("No employees found with the given parameters");
        }
        return employees;
    }

    public boolean deleteEmplooyee(int id){
        for (Employee employee : employeeList) {
            if (employee.getId() == id) {
                employeeList.remove(employee);
                return true;
            }
        }
        return false;
    }

    public Employee updateEmployee(int id
                                   , UpdateEmployeeRequest employee) {
        Employee requestedEmployee = employeeList.stream().filter(employee1 -> employee1.getId() == id).findFirst().orElse(null);
        if(requestedEmployee != null) {
            requestedEmployee.setFirstName(employee.getFirstName());
            requestedEmployee.setLastName(employee.getLastName());
            return requestedEmployee;
        } else {
            return null;
        }
    }

}
