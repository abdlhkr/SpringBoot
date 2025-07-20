package com.example.spring_data_jpa;

import com.example.spring_data_jpa.configuration.GlobalConfigurationV2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "classpath:app.properties")
@SpringBootApplication
@EnableConfigurationProperties(value = GlobalConfigurationV2.class)
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}
