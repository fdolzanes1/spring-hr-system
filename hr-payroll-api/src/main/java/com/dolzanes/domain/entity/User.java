package com.dolzanes.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private Double hourlyPrice;
}
