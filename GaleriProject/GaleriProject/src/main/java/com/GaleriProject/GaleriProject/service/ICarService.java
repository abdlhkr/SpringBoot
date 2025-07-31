package com.GaleriProject.GaleriProject.service;

import com.GaleriProject.GaleriProject.dto.car.DtoCar;
import com.GaleriProject.GaleriProject.dto.car.DtoCarIU;

public interface ICarService {
    DtoCar saveCar(DtoCarIU dtoCarIU);
}
