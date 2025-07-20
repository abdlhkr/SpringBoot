package com.example.spring_data_jpa.services;

import com.example.spring_data_jpa.dto.DtoHome;

public interface IHomeService {
    public DtoHome getHomeById(int id);
}
