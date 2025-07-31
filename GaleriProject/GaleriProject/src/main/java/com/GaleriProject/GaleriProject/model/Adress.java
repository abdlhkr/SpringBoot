package com.GaleriProject.GaleriProject.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "adress")
public class Adress extends BaseEntity{
    // şimdi base entity bi mapped superclass olduğu için
    // id ve create time buna geldi ondan farklı olanları
    // eklememiz lazım
    @Column(name = "city")
    private String city;
    @Column(name = "district")
    private String district;
    @Column(name = "neighborhood")
    private String neighborhood;
    @Column(name = "street")
    private String street;
}
