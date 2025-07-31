package com.GaleriProject.GaleriProject.controller.Imple;


import com.GaleriProject.GaleriProject.controller.ISaledCarController;
import com.GaleriProject.GaleriProject.controller.RootEntity;
import com.GaleriProject.GaleriProject.dto.saled_car.DtoSaledCar;
import com.GaleriProject.GaleriProject.dto.saled_car.DtoSaledCarIU;
import com.GaleriProject.GaleriProject.model.SaledCar;
import com.GaleriProject.GaleriProject.service.ISaledCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.GaleriProject.GaleriProject.controller.RootEntity.ok;

@RestController
@RequestMapping("/api/sale")
public class SaledCarController implements ISaledCarController {

    @Autowired
    private ISaledCarService saledCarService;

    @PostMapping
    @Override
    public RootEntity<DtoSaledCar> saveSaledCar(@RequestBody DtoSaledCarIU dtoSaledCarIU) {
        return ok(saledCarService.saledCar(dtoSaledCarIU));
    }
}
