package com.example.spring_data_jpa.controller.Imple;

import com.example.spring_data_jpa.controller.IStudentController;
import com.example.spring_data_jpa.dto.DtoStudent;
import com.example.spring_data_jpa.dto.DtoStudentIU;
import com.example.spring_data_jpa.entities.Student;
import com.example.spring_data_jpa.services.IStudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentControllerImple implements IStudentController {

    @Autowired
    private IStudentService studentService;

    @PostMapping("/save")
    @Override
    public DtoStudent saveStudent(@RequestBody @Valid DtoStudentIU dtoStudentIU) {
        return studentService.saveStudent(dtoStudentIU);
    }


    @GetMapping("/all")
    @Override
    public List<DtoStudent> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("getId/{id}")
    @Override
    public DtoStudent getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PutMapping("/update/{id}")
    @Override
    public DtoStudent UpdateStudent(@PathVariable Long id,@RequestBody DtoStudentIU student) {
        return studentService.UpdateStudent(id, student);
    }
}
