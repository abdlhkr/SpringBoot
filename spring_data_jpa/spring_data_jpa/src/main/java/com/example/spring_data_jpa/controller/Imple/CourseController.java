package com.example.spring_data_jpa.controller.Imple;

import com.example.spring_data_jpa.entities.Course;
import com.example.spring_data_jpa.services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    public ICourseService service;

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return service.saveCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return service.getAllCourses();
    }
}
