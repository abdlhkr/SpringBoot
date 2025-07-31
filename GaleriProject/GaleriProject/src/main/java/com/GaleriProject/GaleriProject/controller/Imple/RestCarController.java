package com.GaleriProject.GaleriProject.controller.Imple;

import com.GaleriProject.GaleriProject.controller.ICarController;
import com.GaleriProject.GaleriProject.controller.RootEntity;
import com.GaleriProject.GaleriProject.dto.car.DtoCar;
import com.GaleriProject.GaleriProject.dto.car.DtoCarIU;
import com.GaleriProject.GaleriProject.service.ICarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.GaleriProject.GaleriProject.controller.RootEntity.ok;


@RestController
@RequestMapping("/api/car")
public class RestCarController implements ICarController {

    @Autowired
    private ICarService carService;

    @PostMapping
    @Override
    public RootEntity<DtoCar> save(@RequestBody DtoCarIU dtoCarIU) {
        return ok(carService.saveCar(dtoCarIU));
    }
}
