package com.GaleriProject.GaleriProject.controller.Imple;

import com.GaleriProject.GaleriProject.controller.IGalleristCarController;
import com.GaleriProject.GaleriProject.controller.RootEntity;
import com.GaleriProject.GaleriProject.dto.gallerist_car.DtoGalleristCar;
import com.GaleriProject.GaleriProject.dto.gallerist_car.DtoGalleristCarIU;
import com.GaleriProject.GaleriProject.service.IGalleristCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.GaleriProject.GaleriProject.controller.RootEntity.ok;


@RestController
@RequestMapping("api/gallerist_car")
public class GalleristCarController implements IGalleristCarController {

    @Autowired
    private IGalleristCarService galleristCarService;

    @PostMapping
    @Override
    public RootEntity<DtoGalleristCar> save(@RequestBody DtoGalleristCarIU dtoGalleristCarIU) {
        return ok(galleristCarService.saveGalleristCar(dtoGalleristCarIU));
    }
}
