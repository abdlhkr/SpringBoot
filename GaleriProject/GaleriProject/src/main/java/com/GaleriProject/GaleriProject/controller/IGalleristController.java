package com.GaleriProject.GaleriProject.controller;

import com.GaleriProject.GaleriProject.dto.gallerist.DtoGallerist;
import com.GaleriProject.GaleriProject.dto.gallerist.DtoGalleristIU;

public interface IGalleristController {
    RootEntity<DtoGallerist> saveGallerist(DtoGalleristIU dtoGalleristIU);
}
