package com.GaleriProject.GaleriProject.service;

import com.GaleriProject.GaleriProject.dto.gallerist.DtoGallerist;
import com.GaleriProject.GaleriProject.dto.gallerist.DtoGalleristIU;

public interface IGalleristService {
    DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU);
}
