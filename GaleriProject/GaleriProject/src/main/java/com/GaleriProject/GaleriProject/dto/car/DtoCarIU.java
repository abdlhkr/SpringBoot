package com.GaleriProject.GaleriProject.dto.car;

import com.GaleriProject.GaleriProject.enums.CarStatusType;
import com.GaleriProject.GaleriProject.enums.CurrencyType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DtoCarIU {
    private String plaka;
    private String brand;
    private String model;
    private int productionYear;
    private BigDecimal price;
    private CurrencyType currency;
    private BigDecimal damagePrice;
    private CarStatusType carStatusType;
}
