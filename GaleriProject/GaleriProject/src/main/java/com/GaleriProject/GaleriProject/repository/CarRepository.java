package com.GaleriProject.GaleriProject.repository;

import com.GaleriProject.GaleriProject.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
}
