package com.GaleriProject.GaleriProject.controller.Imple;

import com.GaleriProject.GaleriProject.controller.ICustomerController;
import com.GaleriProject.GaleriProject.controller.RootEntity;
import com.GaleriProject.GaleriProject.dto.customer.DtoCustomer;
import com.GaleriProject.GaleriProject.dto.customer.DtoCustomerIU;
import com.GaleriProject.GaleriProject.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.GaleriProject.GaleriProject.controller.RootEntity.ok;


@RestController
@RequestMapping("api/customer")
public class CustomerController implements ICustomerController {
    @Autowired
    private ICustomerService customerService;


    @PostMapping
    @Override
    public RootEntity<DtoCustomer> createCustomer(@RequestBody DtoCustomerIU dtoCustomerIU) {
        return ok(customerService.createCustomer(dtoCustomerIU));
    }
}
