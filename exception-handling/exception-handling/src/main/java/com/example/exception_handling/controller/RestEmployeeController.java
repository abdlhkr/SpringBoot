package com.example.exception_handling.controller;


import com.example.exception_handling.dto.DtoEmployee;
import com.example.exception_handling.dto.IUEmployee;
import com.example.exception_handling.entity.RootEntitiy;
import com.example.exception_handling.service.Service.IMPL.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class RestEmployeeController extends RestBaseController{

    @Autowired
    private EmployeeService service;

    @GetMapping("/{id}")
    public RootEntitiy<DtoEmployee> getEmployeeById(@PathVariable Long id){
        return  ok(service.findById(id));
    }


    @PostMapping("/create")
    public DtoEmployee createEmployee(@RequestBody IUEmployee employee) {
        return service.createEmployee(employee);
    }

    @GetMapping("/getAll")
    public List<DtoEmployee> getAllEmployees() {
        return service.getAllEmployees();
    }
}
