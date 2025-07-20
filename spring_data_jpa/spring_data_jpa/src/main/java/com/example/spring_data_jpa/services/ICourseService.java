package com.example.spring_data_jpa.services;

import com.example.spring_data_jpa.entities.Course;

import java.util.List;

public interface ICourseService {
    public Course saveCourse(Course course);
    public List<Course> getAllCourses();
}
