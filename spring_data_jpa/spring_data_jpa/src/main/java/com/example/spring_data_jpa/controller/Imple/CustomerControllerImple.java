package com.example.spring_data_jpa.controller.Imple;

import com.example.spring_data_jpa.controller.ICustomerController;
import com.example.spring_data_jpa.dto.DtoCustomer;
import com.example.spring_data_jpa.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerControllerImple implements ICustomerController {

    @Autowired
    private ICustomerService service;

    @GetMapping
    @Override
    public List<DtoCustomer> getAllCustomers() {
        return service.getAllCustomers();
    }
}
