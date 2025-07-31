package com.GaleriProject.GaleriProject.repository;

import com.GaleriProject.GaleriProject.model.GalleristCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleristCarRepository extends JpaRepository<GalleristCar,Long> {

    GalleristCar findByGalleristIdAndCarId(int galleristId,int carId);
}
