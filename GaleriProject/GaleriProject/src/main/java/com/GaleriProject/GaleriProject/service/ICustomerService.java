package com.GaleriProject.GaleriProject.service;

import com.GaleriProject.GaleriProject.dto.adress.DtoAdressIU;
import com.GaleriProject.GaleriProject.dto.customer.DtoCustomer;
import com.GaleriProject.GaleriProject.dto.customer.DtoCustomerIU;
import com.GaleriProject.GaleriProject.model.Customer;

public interface ICustomerService {
    public DtoCustomer createCustomer(DtoCustomerIU dtoCustomerIU);
}