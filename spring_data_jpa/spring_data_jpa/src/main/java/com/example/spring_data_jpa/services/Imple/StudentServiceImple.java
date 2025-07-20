package com.example.spring_data_jpa.services.Imple;

import com.example.spring_data_jpa.controller.DtoCourse;
import com.example.spring_data_jpa.dto.DtoStudent;
import com.example.spring_data_jpa.dto.DtoStudentIU;
import com.example.spring_data_jpa.entities.Student;
import com.example.spring_data_jpa.repository.StudentRepository;
import com.example.spring_data_jpa.services.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImple implements IStudentService {

    @Autowired
    private StudentRepository repository;

    @Override
    public DtoStudent saveStudent(DtoStudentIU dtoStudentIU) {
        Student newstudent  = new Student();
        BeanUtils.copyProperties(dtoStudentIU, newstudent);
        Student dbStudent = repository.save(newstudent);
        DtoStudent response = new DtoStudent();
        BeanUtils.copyProperties(dbStudent, response);
        return response;
    }

    @Override
    public List<DtoStudent> getAllStudents() {
        List<Student> studentList = repository.findAllStudents();
        List<DtoStudent> responseList = studentList.stream()
                .map(student -> {
                    DtoStudent dtoStudent = new DtoStudent();
                    BeanUtils.copyProperties(student, dtoStudent);
                    return dtoStudent;
                }).toList();
        return responseList;
    }

    @Override
    public DtoStudent getStudentById(Long id) {
       Optional<Student> dbStudent = repository.findById(id);
        if (dbStudent.isPresent()) {
            DtoStudent response = new DtoStudent();
            BeanUtils.copyProperties(dbStudent.get(), response);
            List<DtoCourse> dbCourses = dbStudent.get().getCourses().stream()
                    .map(course -> {
                        DtoCourse dtoCourse = new DtoCourse();
                        dtoCourse.setId(course.getId());
                        dtoCourse.setName(course.getName());
                        return dtoCourse;
                    }).toList();
            response.setCourses(dbCourses);
            return response;
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }

    }

    @Override
    public DtoStudent UpdateStudent(Long id, DtoStudentIU student) {
        Student dbstudent = repository.findById(id).orElse(null);
        if(student != null){
            dbstudent.setFirstName(student.getFirstName());
            dbstudent.setLastName(student.getLastName());
            dbstudent.setDateOfBirth(student.getDateOfBirth());
            repository.save(dbstudent);
            DtoStudent response = new DtoStudent();
            BeanUtils.copyProperties(dbstudent, response);
            return response;
        }else {
            throw new RuntimeException("Student not found with id: " + id);
        }
    }
}
