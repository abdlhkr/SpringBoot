package com.GaleriProject.GaleriProject.controller;

import com.GaleriProject.GaleriProject.dto.car.DtoCar;
import com.GaleriProject.GaleriProject.dto.car.DtoCarIU;

public interface ICarController {
    RootEntity<DtoCar> save(DtoCarIU dtoCarIU);
}
