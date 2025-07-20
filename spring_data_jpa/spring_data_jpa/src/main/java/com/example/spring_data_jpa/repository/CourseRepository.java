package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    // This interface will automatically inherit methods for CRUD operations
    // from JpaRepository, such as save, findAll, findById, deleteById, etc.
}
