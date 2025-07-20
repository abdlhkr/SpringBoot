package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entities.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdressRepository extends JpaRepository<Adress, Integer> {
}
