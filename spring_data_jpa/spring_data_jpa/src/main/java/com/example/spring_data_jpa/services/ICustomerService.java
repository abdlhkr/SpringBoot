package com.example.spring_data_jpa.services;

import com.example.spring_data_jpa.dto.DtoCustomer;
import com.example.spring_data_jpa.entities.Customer;

import java.util.List;

public interface ICustomerService {
    List<DtoCustomer> getAllCustomers();
}
