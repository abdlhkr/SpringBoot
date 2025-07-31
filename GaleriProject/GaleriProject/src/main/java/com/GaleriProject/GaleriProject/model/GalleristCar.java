package com.GaleriProject.GaleriProject.model;


import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "gallerist_car",
uniqueConstraints = {@UniqueConstraint(columnNames =
        {"gallerist_id","car_id"},name = "uq_gallerist_car")})
// bu constraint şuna yarıyor bi galeride aynı id ye sahip
// iki araba olamıyor yoksa zaten satılmış arabayı tekrar satmaya
// çalışabilir sistem
public class GalleristCar extends BaseEntity{

    @ManyToOne // bi galericinin birden fazla arabası olabilir
    @JoinColumn(name = "gallerist_id")
    private Gallerist gallerist;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

}
