package com.GaleriProject.GaleriProject.service;

import com.GaleriProject.GaleriProject.dto.adress.DtoAdress;
import com.GaleriProject.GaleriProject.dto.adress.DtoAdressIU;


public interface IAdressService {
    public DtoAdress saveAdress(DtoAdressIU dtoAdressIU);

}
