package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    //HQL formatı bu tablo adı değil sınıf adı column adı değil property adı
    @Query(value = "select * from student", nativeQuery = true)
    List<Student> findAllStudents();

    @Query(value = "from Student s where s.id = :studentID" )
    Optional<Student> findStudentById(Long studentID);
}
