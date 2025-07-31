package com.GaleriProject.GaleriProject.service.serviceIMPL;

import com.GaleriProject.GaleriProject.dto.adress.DtoAdress;
import com.GaleriProject.GaleriProject.dto.gallerist.DtoGallerist;
import com.GaleriProject.GaleriProject.dto.gallerist.DtoGalleristIU;
import com.GaleriProject.GaleriProject.exception.BaseException;
import com.GaleriProject.GaleriProject.exception.ErrorMessage;
import com.GaleriProject.GaleriProject.exception.MessageType;
import com.GaleriProject.GaleriProject.model.Adress;
import com.GaleriProject.GaleriProject.model.Gallerist;
import com.GaleriProject.GaleriProject.repository.AdressRepository;
import com.GaleriProject.GaleriProject.repository.GalleristRepository;
import com.GaleriProject.GaleriProject.service.IGalleristService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;


@Service
public class GalleristService implements IGalleristService {

    @Autowired
    private GalleristRepository galleristRepository;
    @Autowired
    private AdressRepository adressRepository;

    public Gallerist makeGallerist(DtoGalleristIU dtoGalleristIU){
        Gallerist gallerist = new Gallerist();
        Optional<Adress> adress = adressRepository.findById(dtoGalleristIU.getAddressId());
        if(adress.isPresent()){
            gallerist.setAdress(adress.get());
            gallerist.setCreateDate(new Date());
            BeanUtils.copyProperties(dtoGalleristIU, gallerist);
            return gallerist;
        }
        gallerist.setCreateDate(new Date());
        throw new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION,"id : " +  dtoGalleristIU.getAddressId()));
    }

    @Override
    public DtoGallerist saveGallerist(DtoGalleristIU dtoGalleristIU) {
        Gallerist gallerist = new  Gallerist();
        gallerist =  makeGallerist(dtoGalleristIU);
        Gallerist dbGallerist = galleristRepository.save(gallerist);
        DtoGallerist dtoGallerist = new DtoGallerist();
        BeanUtils.copyProperties(dbGallerist, dtoGallerist);
        DtoAdress address = new DtoAdress();
        BeanUtils.copyProperties(dbGallerist.getAdress(),address);
        dtoGallerist.setAdress(address);
        BeanUtils.copyProperties(dbGallerist, dtoGallerist);
        return dtoGallerist;
    }
}
