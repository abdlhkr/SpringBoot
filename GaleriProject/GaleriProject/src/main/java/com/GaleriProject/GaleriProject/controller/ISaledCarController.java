package com.GaleriProject.GaleriProject.controller;

import com.GaleriProject.GaleriProject.dto.saled_car.DtoSaledCar;
import com.GaleriProject.GaleriProject.dto.saled_car.DtoSaledCarIU;
import com.GaleriProject.GaleriProject.model.SaledCar;

public interface ISaledCarController {
    RootEntity<DtoSaledCar> saveSaledCar(DtoSaledCarIU dtoSaledCarIU);
}
