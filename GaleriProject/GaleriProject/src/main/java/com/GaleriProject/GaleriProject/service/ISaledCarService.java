package com.GaleriProject.GaleriProject.service;

import com.GaleriProject.GaleriProject.dto.saled_car.DtoSaledCar;
import com.GaleriProject.GaleriProject.dto.saled_car.DtoSaledCarIU;

public interface ISaledCarService {
    public DtoSaledCar saledCar(DtoSaledCarIU dtoSaledCarIU);
}
