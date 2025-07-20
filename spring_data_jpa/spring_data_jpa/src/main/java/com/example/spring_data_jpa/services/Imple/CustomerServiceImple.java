package com.example.spring_data_jpa.services.Imple;

import com.example.spring_data_jpa.dto.DtoAdress;
import com.example.spring_data_jpa.dto.DtoCustomer;
import com.example.spring_data_jpa.entities.Customer;
import com.example.spring_data_jpa.repository.CustomerRepository;
import com.example.spring_data_jpa.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImple implements ICustomerService {

    @Autowired
    private CustomerRepository repository;


    @Override
    public List<DtoCustomer> getAllCustomers() {
        List<Customer> customerList = repository.findAll();
        return customerList.stream().map(
                customer -> {
                    DtoCustomer dtoCustomer = new DtoCustomer();
                    BeanUtils.copyProperties(customer,dtoCustomer);
                    DtoAdress dtoAdress = new DtoAdress();
                    BeanUtils.copyProperties(customer.getAdress(), dtoAdress);
                    dtoCustomer.setAdress(dtoAdress);
                    return dtoCustomer;
                }
        ).collect(Collectors.toList());
    }
}
