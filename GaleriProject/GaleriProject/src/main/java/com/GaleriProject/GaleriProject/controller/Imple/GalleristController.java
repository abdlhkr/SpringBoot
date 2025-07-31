package com.GaleriProject.GaleriProject.controller.Imple;

import com.GaleriProject.GaleriProject.controller.IGalleristController;
import com.GaleriProject.GaleriProject.controller.RootEntity;
import com.GaleriProject.GaleriProject.dto.gallerist.DtoGallerist;
import com.GaleriProject.GaleriProject.dto.gallerist.DtoGalleristIU;
import com.GaleriProject.GaleriProject.service.serviceIMPL.GalleristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.GaleriProject.GaleriProject.controller.RootEntity.ok;


@RestController
@RequestMapping("/api/gallerist")
public class GalleristController implements IGalleristController {

    @Autowired
    private GalleristService galleristService;

    @PostMapping
    @Override
    public RootEntity<DtoGallerist> saveGallerist(@RequestBody DtoGalleristIU dtoGalleristIU) {
        return ok(galleristService.saveGallerist(dtoGalleristIU));
    }
}
