package com.example.spring_data_jpa.dto;

import com.example.spring_data_jpa.entities.Adress;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DtoCustomer {
    private int id;
    private String name;
    private DtoAdress adress;
}
