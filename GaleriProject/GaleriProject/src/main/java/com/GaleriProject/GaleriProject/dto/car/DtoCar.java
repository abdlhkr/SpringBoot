package com.GaleriProject.GaleriProject.dto.car;

import com.GaleriProject.GaleriProject.dto.DtoBase;
import com.GaleriProject.GaleriProject.enums.CarStatusType;
import com.GaleriProject.GaleriProject.enums.CurrencyType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoCar extends DtoBase {
    private String plaka;
    private String brand;
    private String model;
    private int productionYear;
    private BigDecimal price;
    private CurrencyType currency;
    private BigDecimal damagePrice;
    private CarStatusType carStatusType;
}
