package com.GaleriProject.GaleriProject.service.serviceIMPL;

import com.GaleriProject.GaleriProject.dto.adress.DtoAdress;
import com.GaleriProject.GaleriProject.dto.adress.DtoAdressIU;
import com.GaleriProject.GaleriProject.model.Adress;
import com.GaleriProject.GaleriProject.repository.AdressRepository;
import com.GaleriProject.GaleriProject.service.IAdressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AdressServiceIMPL implements IAdressService {
    @Autowired
    private AdressRepository adressReposityory;

    private Adress createAdress(DtoAdressIU dtoAdressIU) {
        Adress adress = new Adress();
        BeanUtils.copyProperties(dtoAdressIU, adress);
        adress.setCreateDate(new Date());
        return adress;
    }

    @Override
    public DtoAdress saveAdress(DtoAdressIU dtoAdressIU) {
        Adress adress = createAdress(dtoAdressIU);
        Adress dbAdress =  adressReposityory.save(adress);
        DtoAdress dtoAdress = new DtoAdress();
        BeanUtils.copyProperties(dbAdress, dtoAdress);
        return dtoAdress;
    }
}
