package com.example.spring_data_jpa.controller.Imple;


import com.example.spring_data_jpa.configuration.GlobalConfiguration;
import com.example.spring_data_jpa.configuration.GlobalConfigurationV2;
import com.example.spring_data_jpa.configuration.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/property-source")
public class PropertySourceController {

    @Autowired
    private GlobalConfiguration globalConfiguration;
    @Autowired
    private GlobalConfigurationV2  configurationV2;

    @GetMapping
    public String getDataSource(){
        return "Database URL: " + globalConfiguration.getDatabaseUrl() +
               ", Username: " + globalConfiguration.getDatabaseUsername() +
               ", Password: " + globalConfiguration.getDatabasePassword();
    }

    @GetMapping("/servers")
    public List<Server> getServers(){
        return configurationV2.getServers();
    }
}
