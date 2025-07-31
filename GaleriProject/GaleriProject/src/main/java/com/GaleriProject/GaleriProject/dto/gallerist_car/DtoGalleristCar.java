package com.GaleriProject.GaleriProject.dto.gallerist_car;


import com.GaleriProject.GaleriProject.dto.DtoBase;
import com.GaleriProject.GaleriProject.dto.car.DtoCar;
import com.GaleriProject.GaleriProject.dto.gallerist.DtoGallerist;
import com.GaleriProject.GaleriProject.model.Car;
import com.GaleriProject.GaleriProject.model.Gallerist;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoGalleristCar extends DtoBase {
    private DtoGallerist dtoGallerist;
    private DtoCar dtoCar;
}
