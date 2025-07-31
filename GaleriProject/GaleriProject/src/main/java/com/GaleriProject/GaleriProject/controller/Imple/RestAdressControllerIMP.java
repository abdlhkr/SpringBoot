package com.GaleriProject.GaleriProject.controller.Imple;

import com.GaleriProject.GaleriProject.controller.IAdressController;
import com.GaleriProject.GaleriProject.controller.RootEntity;
import com.GaleriProject.GaleriProject.dto.DtoUser;
import com.GaleriProject.GaleriProject.dto.adress.DtoAdress;
import com.GaleriProject.GaleriProject.dto.adress.DtoAdressIU;
import com.GaleriProject.GaleriProject.service.serviceIMPL.AdressServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.GaleriProject.GaleriProject.controller.RootEntity.ok;

@RestController
@RequestMapping("api/adress")
public class RestAdressControllerIMP implements IAdressController {
    @Autowired
    AdressServiceIMPL adressServiceIMPL;


    @PostMapping
    @Override
    public RootEntity<DtoAdress> createAdress(@RequestBody DtoAdressIU dtoAdress) {
        return ok(adressServiceIMPL.saveAdress(dtoAdress));
    }
}
