package com.example.spring_data_jpa.controller;

import com.example.spring_data_jpa.dto.DtoCustomer;

import java.util.List;

public interface ICustomerController {
    List<DtoCustomer> getAllCustomers();
}
