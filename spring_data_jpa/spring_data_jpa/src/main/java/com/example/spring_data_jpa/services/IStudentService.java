package com.example.spring_data_jpa.services;

import com.example.spring_data_jpa.dto.DtoStudent;
import com.example.spring_data_jpa.dto.DtoStudentIU;
import com.example.spring_data_jpa.entities.Student;

import java.util.List;

public interface IStudentService {
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU);
    public List<DtoStudent> getAllStudents();
    public DtoStudent getStudentById(Long id);
    public DtoStudent UpdateStudent(Long id, DtoStudentIU student);
}
