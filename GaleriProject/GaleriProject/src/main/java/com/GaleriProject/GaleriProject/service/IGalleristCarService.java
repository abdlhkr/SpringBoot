package com.GaleriProject.GaleriProject.service;

import com.GaleriProject.GaleriProject.dto.gallerist.DtoGallerist;
import com.GaleriProject.GaleriProject.dto.gallerist_car.DtoGalleristCar;
import com.GaleriProject.GaleriProject.dto.gallerist_car.DtoGalleristCarIU;

public interface IGalleristCarService {
    DtoGalleristCar saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU);
}
