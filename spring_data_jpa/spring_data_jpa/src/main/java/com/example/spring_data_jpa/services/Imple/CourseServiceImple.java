package com.example.spring_data_jpa.services.Imple;

import com.example.spring_data_jpa.entities.Course;
import com.example.spring_data_jpa.repository.CourseRepository;
import com.example.spring_data_jpa.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImple implements ICourseService {

    @Autowired
    private  CourseRepository repository;


    @Override
    public Course saveCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return repository.findAll();
    }
}
