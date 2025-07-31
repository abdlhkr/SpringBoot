package com.GaleriProject.GaleriProject.controller;

import com.GaleriProject.GaleriProject.dto.DtoUser;
import com.GaleriProject.GaleriProject.dto.adress.DtoAdress;
import com.GaleriProject.GaleriProject.dto.adress.DtoAdressIU;

public interface IAdressController {
    public RootEntity<DtoAdress> createAdress(DtoAdressIU dtoAdress);
}
