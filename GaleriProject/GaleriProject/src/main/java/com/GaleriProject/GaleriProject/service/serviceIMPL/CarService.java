package com.GaleriProject.GaleriProject.service.serviceIMPL;

import com.GaleriProject.GaleriProject.dto.car.DtoCar;
import com.GaleriProject.GaleriProject.dto.car.DtoCarIU;
import com.GaleriProject.GaleriProject.model.Car;
import com.GaleriProject.GaleriProject.repository.CarRepository;
import com.GaleriProject.GaleriProject.service.ICarService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CarService implements ICarService {

    @Autowired
    private CarRepository carRepository;

    private Car makeCar(DtoCarIU dtoCarIU){
        Car car = new Car();
        car.setCreateDate(new Date());
        BeanUtils.copyProperties(dtoCarIU, car);
        return car;
    }

    @Override
    public DtoCar saveCar(DtoCarIU dtoCarIU) {
        Car car = makeCar(dtoCarIU);
        Car savedCar = carRepository.save(car);
        DtoCar dtoCar = new DtoCar();
        BeanUtils.copyProperties(savedCar, dtoCar);
        return dtoCar;
    }
}
