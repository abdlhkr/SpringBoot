package com.example.spring_data_jpa.controller.Imple;


import com.example.spring_data_jpa.dto.DtoHome;
import com.example.spring_data_jpa.services.IHomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/home")
public class HomeController {

    @Autowired
    private IHomeService homeService;

    @GetMapping("/{id}")
    public DtoHome getHomeByID(@PathVariable int id) {
        return homeService.getHomeById(id);
    }
}
