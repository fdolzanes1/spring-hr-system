package com.dolzanes.presentation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dolzanes.domain.entity.Payroll;
import com.dolzanes.domain.entity.User;
import com.dolzanes.domain.feign.UserFeign;
import com.dolzanes.domain.service.PayrollService;

@RestController
@RequestMapping(value="/api/payments")
public class PayrollController {
	
	@Autowired
	private PayrollService service;

    @GetMapping(value="/{workedId}")    
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workedId, @RequestBody Payroll payment) {
    	return ResponseEntity.ok().body(service.getPayment(workedId, payment));
    }

}