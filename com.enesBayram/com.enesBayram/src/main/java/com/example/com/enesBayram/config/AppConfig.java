package com.example.com.enesBayram.config;

import com.example.com.enesBayram.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<Employee> employeeList() {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Enes", "Bayram"));
        employeeList.add(new Employee(2, "John", "Doe"));
        employeeList.add(new Employee(3, "Jane", "Smith"));
        return employeeList;
    }
}
