package com.example.spring_data_jpa.repository;

import com.example.spring_data_jpa.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

}
