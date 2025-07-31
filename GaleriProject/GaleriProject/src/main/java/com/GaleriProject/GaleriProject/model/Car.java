package com.GaleriProject.GaleriProject.model;


import com.GaleriProject.GaleriProject.enums.CarStatusType;
import com.GaleriProject.GaleriProject.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "car")
@Getter
@Setter
public class Car extends BaseEntity{

    private String plaka;
    private String brand;
    private String model;
    private int productionYear;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private CurrencyType currency;
    private BigDecimal damagePrice;
    @Enumerated(EnumType.STRING)
    private CarStatusType carStatusType;

}
