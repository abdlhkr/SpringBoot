package com.example.spring_data_jpa.services;

import com.example.spring_data_jpa.dto.DtoAdress;

public interface IAdressService {
    public DtoAdress getAdressById(int id);
}
