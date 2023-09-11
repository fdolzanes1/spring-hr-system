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

@RestController
@RequestMapping(value="/api/payments")
public class PayrollController {
	
	@Autowired
	private UserFeign userFeign;

    @GetMapping(value="/{workedId}")    
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workedId, @RequestBody Payroll payment) {
    	
    	User user = userFeign.findById(workedId).getBody();
        
    	return ResponseEntity.ok().body(
        		new Payroll(
        				user.getName(),
        				payment.getDescription(),
        				user.getHourlyPrice(),
        				payment.getWorkedHours(),
        				user.getHourlyPrice() * payment.getWorkedHours()
        			)
        		);
    }

}