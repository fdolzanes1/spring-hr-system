package com.dolzanes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import com.dolzanes.domain.entity.User;
import com.dolzanes.domain.repository.UserRepository;

@SpringBootApplication
@EnableEurekaClient
public class HrUserApiApplication implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(HrUserApiApplication.class, args); 
	}

	@Override
	public void run(String... args) throws Exception {
		
		userRepository.saveAll(List.of(new User(null, "fabiano dolzanes", "fabiano@mail.com", "123456", 33.0)));
		
	}

}
