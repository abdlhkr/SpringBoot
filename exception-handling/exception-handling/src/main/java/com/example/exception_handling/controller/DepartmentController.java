package com.example.exception_handling.controller;


import com.example.exception_handling.dto.DtoDepartment;
import com.example.exception_handling.service.IDepartmentService;
import com.example.exception_handling.service.Service.IMPL.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService service;

    @PostMapping
    public DtoDepartment createDepartment(@RequestBody DtoDepartment department) {
        return service.addDepartment(department);
    }
    @GetMapping("(/list/{id}")
    public DtoDepartment getDepartmentById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/list")
    public List<DtoDepartment> getAllDepartments() {
        return service.getAllDepartments();
    }
}
