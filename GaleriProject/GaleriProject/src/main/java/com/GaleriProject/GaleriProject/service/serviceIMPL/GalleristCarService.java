package com.GaleriProject.GaleriProject.service.serviceIMPL;

import com.GaleriProject.GaleriProject.dto.adress.DtoAdress;
import com.GaleriProject.GaleriProject.dto.car.DtoCar;
import com.GaleriProject.GaleriProject.dto.gallerist.DtoGallerist;
import com.GaleriProject.GaleriProject.dto.gallerist_car.DtoGalleristCar;
import com.GaleriProject.GaleriProject.dto.gallerist_car.DtoGalleristCarIU;
import com.GaleriProject.GaleriProject.exception.BaseException;
import com.GaleriProject.GaleriProject.exception.ErrorMessage;
import com.GaleriProject.GaleriProject.exception.MessageType;
import com.GaleriProject.GaleriProject.model.Car;
import com.GaleriProject.GaleriProject.model.Gallerist;
import com.GaleriProject.GaleriProject.model.GalleristCar;
import com.GaleriProject.GaleriProject.repository.CarRepository;
import com.GaleriProject.GaleriProject.repository.GalleristCarRepository;
import com.GaleriProject.GaleriProject.repository.GalleristRepository;
import com.GaleriProject.GaleriProject.service.IGalleristCarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class GalleristCarService implements IGalleristCarService {

    @Autowired
    GalleristCarRepository galleristCarRepository;
    @Autowired
    GalleristRepository galleristRepository;
    @Autowired
    CarRepository carRepository;


    public GalleristCar makeCar(DtoGalleristCarIU dtoGalleristCarIU) {
        Optional<Car> car = carRepository.findById(dtoGalleristCarIU.getCar_id());
        Optional<Gallerist> gallerist =  galleristRepository.findById(dtoGalleristCarIU.getGallerist_id());
        if(car.isEmpty() || gallerist.isEmpty()) {
            throw new BaseException(new ErrorMessage(MessageType.GENERAL_EXCEPTION,"car gallerist biri yada her ikisi bulunamadı : " + "car id : " +  dtoGalleristCarIU.getCar_id()+" gallerist id : " + dtoGalleristCarIU.getGallerist_id()));
        }
        Car returnCar = car.get();
        Gallerist returnGallerist = gallerist.get();
        GalleristCar galleristCar = new GalleristCar();
        galleristCar.setGallerist(returnGallerist);
        galleristCar.setCar(returnCar);
        galleristCar.setCreateDate(new Date());
        return galleristCarRepository.save(galleristCar);
    }

    @Override
    public DtoGalleristCar saveGalleristCar(DtoGalleristCarIU dtoGalleristCarIU) {
        GalleristCar galleristCar = makeCar(dtoGalleristCarIU);
        DtoGalleristCar dtoGalleristCar = new DtoGalleristCar();
        DtoCar dtoCar = new DtoCar();
        DtoGallerist dtoGallerist = new DtoGallerist();
        DtoAdress dtoAdress = new DtoAdress();

        BeanUtils.copyProperties(galleristCar.getGallerist(), dtoGallerist);
        BeanUtils.copyProperties(galleristCar.getCar(), dtoCar);
        BeanUtils.copyProperties(dtoGallerist.getAdress(), dtoAdress);
        dtoGalleristCar.getDtoGallerist().setAdress(dtoAdress);
        dtoGalleristCar.setDtoGallerist(dtoGallerist);
        dtoGalleristCar.setDtoCar(dtoCar);
        return dtoGalleristCar;
    }
}
