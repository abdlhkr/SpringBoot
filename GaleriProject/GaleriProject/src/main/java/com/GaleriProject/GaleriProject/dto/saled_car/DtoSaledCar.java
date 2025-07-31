package com.GaleriProject.GaleriProject.dto.saled_car;

import com.GaleriProject.GaleriProject.dto.DtoBase;
import com.GaleriProject.GaleriProject.dto.car.DtoCar;
import com.GaleriProject.GaleriProject.dto.customer.DtoCustomer;
import com.GaleriProject.GaleriProject.dto.gallerist.DtoGallerist;
import com.GaleriProject.GaleriProject.model.Car;
import com.GaleriProject.GaleriProject.model.Customer;
import com.GaleriProject.GaleriProject.model.Gallerist;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoSaledCar extends DtoBase {
    private DtoGallerist gallerist;
    private DtoCar car;
    private DtoCustomer customer;
}
