package com.everis.atm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ServiceAtmApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceAtmApplication.class, args);
	}

}
