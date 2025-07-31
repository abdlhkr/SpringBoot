package com.GaleriProject.GaleriProject.repository;

import com.GaleriProject.GaleriProject.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
