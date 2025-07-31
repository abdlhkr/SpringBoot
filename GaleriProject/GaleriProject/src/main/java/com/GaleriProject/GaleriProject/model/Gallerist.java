package com.GaleriProject.GaleriProject.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "gallerist")
@Getter
@Setter
public class Gallerist extends BaseEntity{
     @Column(name = "firstName")
    private String firstName;
     @Column(name = "last_name")
    private String lastName;

    // galerinin 5 konumu yoktur heralde
    // ama Customer zenginse 10 evi olabilir
    @OneToOne
    private Adress adress;
}
