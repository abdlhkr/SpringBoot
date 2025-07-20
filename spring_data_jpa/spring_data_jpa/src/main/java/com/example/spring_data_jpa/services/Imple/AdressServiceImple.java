package com.example.spring_data_jpa.services.Imple;

import com.example.spring_data_jpa.dto.DtoAdress;
import com.example.spring_data_jpa.dto.DtoCustomer;
import com.example.spring_data_jpa.entities.Adress;
import com.example.spring_data_jpa.entities.Customer;
import com.example.spring_data_jpa.repository.AdressRepository;
import com.example.spring_data_jpa.services.IAdressService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdressServiceImple implements IAdressService {

    @Autowired
    private AdressRepository repository;

    @Override
    public DtoAdress getAdressById(int id) {
        Optional<Adress> adress = repository.findById(id);
        if(adress.isPresent()) {
            DtoAdress dtoAdress = new DtoAdress();
            BeanUtils.copyProperties(adress.get(), dtoAdress);
            Customer customer = adress.get().getCustomer();
            DtoCustomer dtoCustomer = new DtoCustomer();
            BeanUtils.copyProperties(customer, dtoCustomer);
            dtoAdress.setCustomer(dtoCustomer);
            return dtoAdress;
        }else{
            return null;
        }
    }
}
