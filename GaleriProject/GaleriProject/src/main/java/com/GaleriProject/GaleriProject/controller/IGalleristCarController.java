package com.GaleriProject.GaleriProject.controller;

import com.GaleriProject.GaleriProject.dto.gallerist_car.DtoGalleristCar;
import com.GaleriProject.GaleriProject.dto.gallerist_car.DtoGalleristCarIU;

public interface IGalleristCarController {
    RootEntity<DtoGalleristCar> save(DtoGalleristCarIU dtoGalleristCarIU);
}
