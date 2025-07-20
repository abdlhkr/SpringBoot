package com.example.spring_data_jpa.configuration;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "app")
// not : configuration properties de bean oluşurulması için @EnableConfigurationProperties anotasyonu kullanılır.
// componente ondan gerek yok
public class GlobalConfigurationV2 {
    private List<Server> servers;
}
