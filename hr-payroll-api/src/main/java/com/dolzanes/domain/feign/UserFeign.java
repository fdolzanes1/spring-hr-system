package com.dolzanes.domain.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dolzanes.domain.entity.User;

@FeignClient(name="hr-user-api")
public interface UserFeign {
	
	@GetMapping(value="/api/users/{id}")
	ResponseEntity<User> findById(@PathVariable Long id);
	
	@GetMapping
	ResponseEntity<List<User>> findAll();
}
