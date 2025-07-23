package com.example.JWT.controller;


import com.example.JWT.dto.DtoEmployee;
import com.example.JWT.service.EmployeeService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class RestEmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/get/{id}")
    public DtoEmployee findById( @PathVariable long id) {
        return employeeService.findById(id);
    }
}
