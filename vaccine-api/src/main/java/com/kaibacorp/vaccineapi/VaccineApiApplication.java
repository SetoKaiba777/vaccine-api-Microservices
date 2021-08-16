package com.kaibacorp.vaccineapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class VaccineApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccineApiApplication.class, args);
	}

}
