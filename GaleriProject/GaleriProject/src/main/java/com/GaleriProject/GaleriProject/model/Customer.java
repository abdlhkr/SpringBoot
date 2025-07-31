package com.GaleriProject.GaleriProject.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "customer")
@Data
public class Customer extends BaseEntity{
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "tckn")
    private String tckn;
    @Column(name = "birth_of_date")
    private Date birthOfDate;

    @OneToMany
    private List<Adress> adressList ;

    @OneToOne
    private Account account;
}
