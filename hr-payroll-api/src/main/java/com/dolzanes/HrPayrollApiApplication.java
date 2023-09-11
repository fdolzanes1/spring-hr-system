package com.dolzanes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HrPayrollApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrPayrollApiApplication.class, args);
	}

}
