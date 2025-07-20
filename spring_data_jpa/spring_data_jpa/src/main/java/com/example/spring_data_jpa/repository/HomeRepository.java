package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entities.Home;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HomeRepository extends JpaRepository<Home, Integer> {

}
