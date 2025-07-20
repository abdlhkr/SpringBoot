package com.example.spring_data_jpa.dto;


import com.example.spring_data_jpa.entities.Customer;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DtoAdress {
    private int id;
    private String description;
    private DtoCustomer customer;
}
