package com.example.spring_data_jpa.controller.Imple;


import com.example.spring_data_jpa.dto.DtoAdress;
import com.example.spring_data_jpa.services.IAdressService;
import com.example.spring_data_jpa.services.Imple.AdressServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/adress")
public class AdressController {

    @Autowired
    private IAdressService service;


    @GetMapping("/{id}")
    public DtoAdress getAdressById(@PathVariable int id) {
        return service.getAdressById(id);
    }
}
