package com.GaleriProject.GaleriProject.controller;

import com.GaleriProject.GaleriProject.dto.customer.DtoCustomer;
import com.GaleriProject.GaleriProject.dto.customer.DtoCustomerIU;

public interface ICustomerController {
    RootEntity<DtoCustomer> createCustomer(DtoCustomerIU dtoCustomerIU);
}
